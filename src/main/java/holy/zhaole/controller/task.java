package holy.zhaole.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class task implements Job{
	
	private static final String userName="15736708180";
	
	private static final String password="lxp521";
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("执行任务------------"+simpleDateFormat.format(new Date()));
		//添加任务,登录京东，签到
		SignIn.signJingDong(userName, password);
		
	}
}
