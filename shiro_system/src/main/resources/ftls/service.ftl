package ${pack};

import java.util.*;
${importEntity};

/**
 * @author ${annotation.authorName}
 * @data ${annotation.date}
 *
 * @version ${annotation.version}
 */
 

 public interface ${ClassName}Service {
 
 	public int insert (${ClassName} ${className}) throws Exception;
 	
 	public int del(String ${Pk}) throws Exception;
 	
 	public int update(${ClassName} ${className}) throws Exception;
 	
 	public List<${ClassName}> pageList(int pageIndex,int pageSize,String nameKey) throws Exception;
	
	public long pageTotalCount() throws Exception;
	
	public ${ClassName} findById(String ${Pk}) throws Exception;
 
 }
	
	
	
	

	
