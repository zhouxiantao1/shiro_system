package ${pack};

import java.util.*;

import org.apache.ibatis.annotations.Param;
${importEntity};

/**
 * @author ${annotation.authorName}
 * @data ${annotation.date}
 *
 * @version ${annotation.version}
 */
 

 public interface ${ClassName}Dao{
 
 	public int insert (${ClassName} ${className}) throws Exception;
 	
 	public int del(String ${Pk}) throws Exception;
 	
 	public int update(${ClassName} ${className}) throws Exception;
 	
 	public List<${ClassName}> pageList(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("nameKey")String nameKey) throws Exception;
	
	public long pageTotalCount() throws Exception;
	
	public ${ClassName} findById(String ${Pk}) throws Exception;
 
 }
	
	
	
	

	
