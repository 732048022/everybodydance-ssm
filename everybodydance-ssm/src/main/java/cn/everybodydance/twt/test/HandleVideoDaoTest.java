package cn.everybodydance.twt.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.everybodydance.twt.dao.HandleVideoDao;
import cn.everybodydance.twt.entity.Video;

/**
 * 测试类测试视频增删改查
 * @author tanwentao
 *
 */
public class HandleVideoDaoTest extends BaseTest{
	/**
	 * 注入handleVideoDao
	 */
	@Autowired
	private HandleVideoDao handleVideoDao;
	
	/**
	 * 测试插入视频
	 * @throws Exception
	 */
	@Test
	public void testInsertVideo() throws Exception{
		String path="/aaa/bbb/ccc";
		String title="ak";
		String group="001";
		int index=11;
		Video video=new Video();
		video.setGroup(group);
		video.setIndex(index);
		video.setPath(path);
		video.setTitle(title);
		handleVideoDao.insertVideo(video);
	}
	/**
	 * 测试删除视频
	 * @throws Exception
	 */
	@Test
	public void testDeleteVideo() throws Exception{
		int index=11;
		String group="001";
		handleVideoDao.deleteVideo(index,group);
	}
	/**
	 * 测试更新视频名字
	 * @throws Exception
	 */
	@Test
	public void testUpdateVideo() throws Exception{
		String newtitle="1111111111";
		int index=1;
		String group="001";
		handleVideoDao.updateVideo(newtitle, index,group);
	}
	/**
	 * 根据不同的分组分页查询视频信息
	 * @return
	 * @throws Exception
	 */
	@Test
	public void testSelectVideo4Group() throws Exception{
		int pagesize=5;
		int startrow=5;
		String group="001";
		List<Video> list=handleVideoDao.selectVideo4Group(startrow, pagesize, group);
		System.out.println(list);
	}
	/**
	 * 根据视频标题找到排序字段
	 * @throws Exception
	 */
	@Test
	public void testSelectIdByTitle() throws Exception{
		String title="ad";
		String group="001";
		int index=handleVideoDao.selectIdByTitle(title,group);
		System.out.println(index);
	}
}
