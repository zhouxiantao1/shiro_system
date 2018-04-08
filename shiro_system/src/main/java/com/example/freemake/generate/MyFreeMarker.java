package com.example.freemake.generate;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.example.freemake.util.Annotation;
import com.example.freemake.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MyFreeMarker {
	
	static Logger log = Logger.getLogger(MyFreeMarker.class.getName());
	
	private static Configuration configuration;
	private static Template template;
	private static Writer writer;
	
	public static final String ANNOTATION = "annotation";
	public static final String ANNOTATION_AUTHOR_NAME = "zhouxiantao";
	public static final String ANNOTATION_AUTHOR_EMAIL = "zhouxiantao@163.com";
	
	public static final String ANNOTATION_VERSION = "1.0";
	public static final String DATE_FROMATE = "yyyy-MM-dd HH:mm:ss";
	
	public static final String FTLS_PATH = "/ftls/";
	public static final String CONTROLLER = "controller.ftl";
	public static final String ENTITY = "entity.ftl";
	public static final String SERVICE = "service.ftl";
	public static final String SERVICE_IMPL = "serviceImpl.ftl";
	public static final String IDao = "dao.ftl";
	public static final String SQLMAPPER = "mapper.ftl";
	public static final String LIST_JSP = "listjsp.ftl";
	public static final String ADD_JSP = "addjsp.ftl";
	public static final String EDIT_JSP = "editjsp.ftl";
	public static final String DETAIL_JSP = "detailjsp.ftl";
	
	public static Map<String, Object> map=new HashMap<String,Object>();
	
	
	
	/**
	 * @param tableName 表名
	 * @param createUser 创建者
	 * @param module 模块
	 * @param modulename 模块名称
	 * @param modulename 模块名称
	 * @param catalog  目录名称
	 * */
	public static void CreateFile(String tableName,String createUser,String module,String modulename,
			String prefix,String catalog)throws Exception{
		map.put("tableName",tableName);
		map.put("createUser",createUser) ;
		map.put("module",module) ;
		map.put("prefix",prefix) ;
		map.put("modulename",modulename) ;
		map.put("catalog",catalog) ;
		
		getPropertiesEles(map);
		
		List<Map<String,String>> list = MarkerDbConnection.select(map);
		if(list!=null && list.size()>0){
			configuration = new Configuration();
			configuration.setClassForTemplateLoading(new MyFreeMarker().getClass(), FTLS_PATH);
			
			Annotation annotation = new Annotation();
			annotation.setAuthorEmail(ANNOTATION_AUTHOR_EMAIL);
			annotation.setAuthorName(createUser);
			annotation.setVersion(ANNOTATION_VERSION);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FROMATE);
			annotation.setDate(simpleDateFormat.format(new Date()));
			String className = StringUtils.getHumpName(tableName);
			String pk ="id";
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("key")!=null && list.get(i).get("key").equals("PRI"))
					pk = list.get(i).get("column_name");
			}
			map.put("pk", pk);
			
			CreateController(tableName,className, list, annotation, map, pk);
			CreateEntity(className, list, annotation, map);
			CreateService(className, list, annotation, map, pk);
			CreateServiceImpl(className, list, annotation, map, pk);
			CreateDao(className, list, annotation, map, pk);
			CreateSqlMapper(tableName, className, list, annotation, map, pk);
			CreateListJSP(className, list, annotation, map, pk);
			CreateAddJSP(tableName,className, list, annotation, map, pk);
			CreateEditJSP(tableName, className, list, annotation, map, pk);
			CreateDetailJSP(tableName, className, list, annotation, map, pk);
//			MarkerDbConnection.createPermission(list,tableName, map);
			
			if(MarkerDbConnection.selectBaseSeq(map)<1)
				MarkerDbConnection.createBaseSeq();
			if(MarkerDbConnection.insertSequence(tableName, prefix)<0)
				 System.out.println("[BASE_KEY_SEQUENCE]表新增数据出错!");
			else
				System.out.println("[BASE_KEY_SEQUENCE]表新增数据成功!");
		}
		
	}
	
	public static void CreateController(String tableName,String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(CONTROLLER);
			
			Map<String, Object> root = new HashMap<String, Object>();

			String ClassName = StringUtils.upperCaseFirstOne(className);
			
			String importService = "import "+module+".service."+ClassName+"Service";
			String importEntity = "import "+module+".entity."+ClassName;
			root.put("importservice", importService);
			root.put("importEntity", importEntity);
			
			String alias = module+".entity."+ClassName;
			root.put("alias", alias);
			
			String mapper = (module+".mapper.").replace(".", "/")+ClassName+"Mapper.xml";
			root.put("mapper", mapper);
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
			root.put("tableName", tableName);
			root.put("module", map.get("module"));
			
			module = module + ".controller";
			root.put("pack", module);
					
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			String beanFilePath = beanPath+ClassName+"Controller.java";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			
			writer = new FileWriter(file); 
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[创建controller成功!]");
		}catch(Exception e){
			System.out.println("controller创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void CreateEntity(String className,List<Map<String,String>> list,Annotation annotation,Map map){
		
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(ENTITY);
			
			Map<String,Object> root = new HashMap<String,Object>();
			module = module + ".entity";
			root.put("pack", module);
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			String beanFilePath = beanPath+ClassName+".java";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("list", list);
			
			writer = new FileWriter(file); 
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[创建实体类成功!]");
		}catch(Exception e){
			System.out.println("[实体创建异常!]"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void CreateService(String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(SERVICE);

			Map<String ,Object> root = new HashMap<String,Object>();
			module = module+".service";
			root.put("pack", module);
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+ClassName+"Service.java";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			String importEntity = "import "+map.get("base_package").toString()+"."+map.get("module").toString()+".entity."+ClassName;
			root.put("importEntity", importEntity);
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[service接口生成成功!]");
		}catch(Exception e){
			System.out.println("service接口创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void CreateServiceImpl(String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(SERVICE_IMPL);

			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String importText = "import "+module+".service."+ClassName+"Service;"+
			"\nimport "+module+".dao."+ClassName+"Dao;";
			
			module = module+".service.impl";
			root.put("pack", module);
			root.put("import", importText);
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+ClassName+"ServiceImpl.java";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			String importEntity = "import "+map.get("base_package").toString()+"."+map.get("module").toString()+".entity."+ClassName;
			root.put("importEntity", importEntity);
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[service生成成功!]");
		}catch(Exception e){
			System.out.println("service创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void CreateDao(String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(IDao);

			Map<String ,Object> root = new HashMap<String,Object>();
			module = module+".dao";
			root.put("pack", module);
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
						
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+ClassName+"Dao.java";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			String importEntity = "import "+map.get("base_package").toString()+"."+map.get("module").toString()+".entity."+ClassName;
			root.put("importEntity", importEntity);
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[Dao接口生成成功!]");
		}catch(Exception e){
			System.out.println("Dao接口创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void CreateSqlMapper(String tableName,String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			String module = map.get("base_package").toString()+"."+map.get("module").toString();
			template = configuration.getTemplate(SQLMAPPER);
			
			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("pack", module);
			module = module+".mapper";
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
			root.put("tableNames", list);
			CreateSql(tableName, list, root, pk);
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/src/"+module.replace(".", "/")+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+ClassName+"Mapper.xml";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("key")!=null && list.get(i).get("key").equals("PRI"))
					list.remove(i);
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("list", list);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[sqlMapper生成成功!]");
		}catch(Exception e){
			System.out.println("sqlMapper创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
	}
	
public static void CreateListJSP(String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			template = configuration.getTemplate(LIST_JSP);
			template.setEncoding("UTF-8");
			
			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("catalog", map.get("catalog"));
			root.put("pk", pk);
			root.put("Pk", StringUtils.getHumpName(pk));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/WebContent/WEB-INF/pages/"+className+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+className+"_list.jsp";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("list", list);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[list_jsp生成成功!]");
		}catch(Exception e){
			System.out.println("list_jsp创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
		
	}

	public static void CreateAddJSP(String tableName,String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			template = configuration.getTemplate(ADD_JSP);
			template.setEncoding("UTF-8");
			
			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("catalog", map.get("catalog"));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/WebContent/WEB-INF/pages/"+className+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+className+"_add.jsp";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("tableName", tableName);
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("key")!=null && list.get(i).get("key").equals("PRI"))
					list.remove(i);
			}
			
			root.put("list", list);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[add_jsp生成成功!]");
		}catch(Exception e){
			System.out.println("add_jsp创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void CreateEditJSP(String tableName,String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			template = configuration.getTemplate(EDIT_JSP);
			template.setEncoding("UTF-8");
			
			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("catalog", map.get("catalog"));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/WebContent/WEB-INF/pages/"+className+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+className+"_edit.jsp";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("tableName", tableName);
			root.put("Pk", StringUtils.getHumpName(pk));
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("key")!=null && list.get(i).get("key").equals("PRI"))
					list.remove(i);
			}
			
			root.put("list", list);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[edit_jsp生成成功!]");
		}catch(Exception e){
			System.out.println("edit_jsp创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
public static void CreateDetailJSP(String tableName,String className,List<Map<String,String>> list,Annotation annotation,Map map,String pk){
		
		try{
			template = configuration.getTemplate(DETAIL_JSP);
			template.setEncoding("UTF-8");
			
			Map<String ,Object> root = new HashMap<String,Object>();
			root.put("catalog", map.get("catalog"));
			
			String ClassName = StringUtils.upperCaseFirstOne(className);
			String beanPath = map.get("workspace")+"/WebContent/WEB-INF/pages/"+className+"/";
			File filePath = new File(beanPath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String beanFilePath = beanPath+className+"_detail.jsp";
			File file = new File(beanFilePath);
			if(!file.exists()){
				file.createNewFile();
			}
			
			root.put("annotation", annotation );
			root.put("ClassName", ClassName);
			root.put("className", className);
			root.put("tableName", tableName);
			root.put("Pk", StringUtils.getHumpName(pk));
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("key")!=null && list.get(i).get("key").equals("PRI"))
					list.remove(i);
			}
			
			root.put("list", list);
			
			writer = new FileWriter(file);
			template.process(root, writer);
			writer.flush();
			writer.close();
			System.out.println("[detail_jsp生成成功!]");
		}catch(Exception e){
			System.out.println("detail_jsp创建异常！问题" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void CreateSql(String tableName,List<Map<String,String>> list,Map<String ,Object> root,String pk){
		
		String insert = "insert into "+tableName+"(";
		String values = "values (";
		String where = " where "+pk+"=#{"+StringUtils.getHumpName(pk)+"}";
		String update = "update "+tableName+" set ";
		String delete = "delete from "+tableName;
		
		String select = "select <include refid='columns'></include> from "+tableName;
		String count = "select count(*) from "+tableName;
		
		String columns ="";
		StringBuffer wheres = new StringBuffer();
		wheres.append("\n\t\t<where>\n");
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				insert += list.get(i).get("column_name")+")";
				values += "#{"+list.get(i).get("humpColumnName")+"})";
				update += list.get(i).get("column_name")+"=#{"+list.get(i).get("humpColumnName")+"}";
				columns += list.get(i).get("column_name")+" as "+list.get(i).get("humpColumnName");
				break;
			}
			insert += list.get(i).get("column_name")+",";
			values += "#{"+list.get(i).get("humpColumnName")+"},";
			update += list.get(i).get("column_name")+"=#{"+list.get(i).get("humpColumnName")+"},";
			columns += list.get(i).get("column_name")+" as "+list.get(i).get("humpColumnName")+",";
			
			wheres.append("\t\t\t<if test=\"").append(list.get(i).get("humpColumnName")).append("!=null")
				.append(" ||").append(list.get(i).get("humpColumnName")).append("!=''\">")
				.append(list.get(i).get("column_name")).append("=").append("#{")
				.append(list.get(i).get("humpColumnName")).append("}</if>\n");
		}
		wheres.append("\t\t\t<if test='pageIndex!=null and pageSize!=null'>limit  #{pageIndex},#{pageSize}</if>\n");
		wheres.append("\t\t</where>\n");
	
		root.put("insert", insert+values);
		root.put("update", update+where);
		root.put("delete", delete+where);
		root.put("selectById", select+where);
		root.put("selectPage", select+wheres);
		root.put("columns", columns);
		root.put("count", count);
	}
	
	public static void getPropertiesEles(Map map)throws Exception{
		InputStream in = new BufferedInputStream(new FileInputStream(MarkerDbConnection.JDBC));
		Properties pro = new Properties();
		pro.load(in);
		Iterator it = pro.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry= (Map.Entry<String, String>)it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			map.put(key,value);
		}
	}
	
	public static void getPropertiesElesTomcat(Map map,InputStream in)throws Exception{
		Properties pro = new Properties();
		pro.load(in);
		Iterator it = pro.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry= (Map.Entry<String, String>)it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			map.put(key,value);
		}
	}
	
}
