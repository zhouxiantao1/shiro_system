package ${pack};

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
${importEntity};
${import}

/**
 * @author ${annotation.authorName}
 * @data ${annotation.date}
 *
 * @version ${annotation.version}
 */

@Service("${className}Service")
public class ${ClassName}ServiceImpl implements ${ClassName}Service{

	@Autowired
	private ${ClassName}Dao ${className}Dao;
	
	public int insert (${ClassName} ${className}) throws Exception{
		return ${className}Dao.insert(${className});
	}
 	
 	public int del(String ${Pk}) throws Exception{
 		return ${className}Dao.del(${Pk});
 	}
 	
 	public int update(${ClassName} ${className}) throws Exception{
 		return ${className}Dao.update(${className});
 	}
 	
 	public List<${ClassName}> pageList(int pageIndex,int pageSize,String nameKey) throws Exception{
 		return ${className}Dao.pageList(pageIndex,pageSize,nameKey);
 	}
	
	public long pageTotalCount() throws Exception{
		return ${className}Dao.pageTotalCount();
	}
	
	public ${ClassName} findById(String ${Pk}) throws Exception{
		return ${className}Dao.findById(${Pk});
	}

}