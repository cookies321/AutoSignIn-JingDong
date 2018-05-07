package holy.zhaole.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;


public class Scheduler {
	
	public static void init(){
		
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		
		try {
			org.quartz.Scheduler scheduler =stdSchedulerFactory.getScheduler();
			 //第一个是任务的名称，第二个是组名，第三个就是实际当任务需要执行的回调类。  
            JobDetail jobDetail = new JobDetail("mytask",  "groupsimpletrigger", task.class);  
            //第一个是Trigger的名称，第二个是Trigger的组名，第三个是任务开始时间，第四个是结束时间，第五个是重复
            //次数（使用SimpleTrigger.REPEAT_INDEFINITELY常量表示无限次），最后一个是重复周期（单位是毫秒），  
            //触发器，之后每*秒执行一次 
            SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
            System.out.println("现在时间为每天的："+sf.format(new Date()));
            
			Date date=null;
			
			try {
				date = sf.parse("10:00:00");
				
				System.out.println("设定任务执行定时时间为："+sf.format(date));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            SimpleTrigger simpletrigger = new SimpleTrigger(
                    "simpletrigger",
                    "groupsimpletrigger",
                    date,
                    null,
                    SimpleTrigger.REPEAT_INDEFINITELY,
                    86400L * 1000L); 
            //给我们的时间计划sched添加job及触发器，每个sched可添加多个job及触发器  
            scheduler.scheduleJob(jobDetail, simpletrigger);  
            //启动 
            scheduler.start();  
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Description 启动定时器
	 * @author 赵乐
	 * @date 2017年12月29日 上午9:06:37
	 * @action main
	 * @param @param args
	 * @return void
	 */
	public static void main(String[] args) {
		init();
	}

}
