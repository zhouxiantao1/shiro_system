<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${pack}.dao.${ClassName}Dao">

	<sql id="columns"> 
		${columns}
	</sql>
	
	<select id="findById" resultType="${pack}.entity.${ClassName}" parameterType="String">
		${selectById}
	</select>
	
	<select id="pageList" resultType="${pack}.entity.${ClassName}">
		${selectPage}
	</select>
	
	<select id="pageTotalCount" resultType="long">
		${count}
	</select>
	
	<delete id="del" parameterType="String">
		${delete}
	</delete>
	
	<update id="update" parameterType="${pack}.entity.${ClassName}">
		${update}
	</update>
	
	<insert id="insert" parameterType="${pack}.entity.${ClassName}" >
		${insert}
	</insert>
	
</mapper>
	