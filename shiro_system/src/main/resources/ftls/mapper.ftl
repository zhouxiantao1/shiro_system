<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${pack}.dao.${ClassName}Dao">
	
	<resultMap type="${className}" id="BaseResult">
		<id  property="${Pk}" column="${pk}" />
	<#list list as p>
		<result property="${p.humpColumnName}" column="${p.column_name}"/>
	</#list>
	</resultMap>
	
	<parameterMap type="${className}" id="BaseParam">
		<parameter property="${Pk}"/>
	<#list list as p>
		<parameter property="${p.humpColumnName}"/>
	</#list>
	</parameterMap>
	
	<sql id="columns"> 
		${columns}
	</sql>
	
	<select id="findById" resultType="BaseResult" parameterType="String">
		${selectById}
	</select>
	
	<select id="pageList" resultType="BaseResult">
		${selectPage}
	</select>
	
	<select id="pageTotalCount" resultType="long">
		${count}
	</select>
	
	<delete id="del" parameterType="String">
		${delete}
	</delete>
	
	<update id="update" parameterType="BaseParam">
		${update}
	</update>
	
	<insert id="insert" parameterType="BaseParam" >
		${insert}
	</insert>
	
</mapper>
	