package org.sc.rest.provider.server.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yjlc.commons.exception.ServiceException;

import tk.mybatis.mapper.common.Mapper;
/**
 * 描述: 一般操作数据库都在Service中进行，不可避免的就要写出大量重复的CRUD方法，如果能有一个通用的Service，肯定也会减少很多工作量。 
 * 作者: 扫地僧
 * 公司: 深圳市前海技术有限公司
 * 日期: 2017-4-4 下午12:23:49 
 * 版本号: V1.0 
 * @param <T>
 */
@Service
public abstract class BaseService<T> {
@Autowired
protected Mapper<T> mapper;
/**
 * 描述: 通用的保存方法
 * 参数: @param entity
 * 参数: @return
 * 返回值类型: int
 * 作者: 扫地僧 
 * 日期: 2017-4-4 下午12:20:40
 */
public int insert(T entity){
	if (entity == null) {
        throw new ServiceException("保存的对象不能为空!");
    }
    return mapper.insert(entity);
}
/**
 * 描述: 保存一个实体，null的属性不会保存，会使用数据库默认值
 * 参数: @param entity
 * 参数: @return
 * 返回值类型: int
 * 作者: 扫地僧 
 * 日期: 2017-4-4 下午1:24:54
 */
public int insertSelective(T entity){
	if (entity == null) {
		throw new ServiceException("保存的对象不能为空!");
	}
	return mapper.insert(entity);
}
/**
 * 描述: 通用的根据主键进行删除
 * 参数: @param entity
 * 参数: @return
 * 返回值类型: int
 * 作者: 扫地僧 
 * 日期: 2017-4-4 下午12:20:13
 */
public int delete(T entity){
    return mapper.deleteByPrimaryKey(entity);
}
/**
 * 描述: 根据主键进行修改
 * 参数: @param entity
 * 参数: @return
 * 返回值类型: int
 * 作者: 扫地僧 
 * 日期: 2017-4-4 下午12:21:18
 */
public int update(T entity){
    return mapper.updateByPrimaryKey(entity);
}

/**
 * 单表分页查询
 * 
 * @param pageNum
 * @param pageSize
 * @return
 */
public List<T> selectPage(int pageNum,int pageSize){
    PageHelper.startPage(pageNum, pageSize);
    //Spring4支持泛型注入  切记：只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
    return mapper.select(null);
}

/**
 * 单表分页查询总条数
 * 
 * @param pageNum
 * @param pageSize
 * @return
 */
public int selectCount(T entity){
    return mapper.selectCount(entity);
}

/**
 * 描述: 根据主键查询单个信息 
 * 参数: @param entity
 * 参数: @return
 * 返回值类型: T
 * 作者: 扫地僧 
 * 日期: 2017-4-4 下午12:26:02
 */
public T selectOne(T entity){
    return mapper.selectOne(entity);
}
}
