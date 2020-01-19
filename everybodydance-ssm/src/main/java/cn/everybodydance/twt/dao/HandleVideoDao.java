package cn.everybodydance.twt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.everybodydance.twt.entity.Video;

public interface HandleVideoDao {
	/**
	 * 新增视频
	 * 
	 * @param path  保存在服务器本地的路径
	 * @param title 视频标题（主键）
	 * @param group 视频分组（女神组：001 女王祖：002 艺能组：003 天赋组：004）
	 * @param index 视频排列字段
	 * @return
	 */
	void insertVideo(@Param("video") Video video);

	/**
	 * 删除视频
	 * 
	 * @param title 视频标题
	 * @param group  分组
	 */
	void deleteVideo(@Param("index")int index,@Param("group")String group);

	/**
	 * 根据下标和组名查询视频真正的路径
	 * @param index
	 * @param group
	 * @return
	 */
	String selectPathByIndexAndGroup(@Param("index")int index,@Param("group")String group);
	/**
	 * 根据index修改视频名字
	 * 
	 * @param newtitle 新的视频名字
	 * @param index    视频排列字段
	 * @param group  分组
	 */
	void updateVideo(@Param("newtitle") String newtitle, @Param("index") int index,@Param("group")String group);

	/**
	 * 根据不同的分组分页查询视频信息
	 * 
	 * @param pagesize  当前页数
	 * @param totalpage 每页显示的条数
	 * @param group 分组
	 * @return
	 */
	List<Video> selectVideo4Group(@Param("startrow") int startrow, @Param("pagesize") int pagesize,
			@Param("group") String group);

	/**
	 * 根据视频标题找到排序字段
	 * 
	 * @param title 标题
	 * @param group  分组
	 * @return
	 */
	int selectIdByTitle(@Param("title")String title,@Param("group")String group);
}
