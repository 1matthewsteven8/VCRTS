import java.awt.Color;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FIFOTest {
	
	private Queue<Job> queue = new LinkedList<Job>();
	
	public FIFOTest()
	{
		queue = new LinkedList<Job>();
	}
	
	public void queueAdd(Job job)
	{
		queue.add(job);
	}
	
	public Job queueRemove()
	{
		return queue.remove();
	}
	
	public Job getCurrentJob()
	{
		return queue.element();
	}
	
	/* The method below calculates the amount of time it will take for the job entered to be completed (including the duration
	of the job entered). */
	public int getCompletionTime(Job job)
	{
		int time = job.getJobDuration();
		Queue<Job> tempqueue = new LinkedList<>(queue);
		Job currentJob = tempqueue.remove();
		
		while (currentJob.getJobID() != job.getJobID())
		{
			time += currentJob.getJobDuration();
			currentJob = tempqueue.remove();
		}
		
		return time;
	}
	
	// This method returns the job at the entered position in the queue.
	public Job getJob(int position)
	{
		Queue<Job> tempqueue = new LinkedList<>(queue);
		Job currentJob = new Job();
		
		for (int i = 0; i < position; i++)
		{
			currentJob = tempqueue.remove();
		}
		
		return currentJob;
	}

	public class completeTime {
		
	    public completeTime() {
	    	JFrame frame = new JFrame();
	    	JPanel jobInfoPanel, timeCompletedPanel; 
	    	JLabel joblabel, timeLabel, jobInstructions, timeInstructions, finalTime;
	        frame.setTitle("Completion Time");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(null);
	        JButton backButton;
			    
	        // setting the bounds for the JFrame
	        frame.setBounds(100,100,645,470);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);   
	        Border br = BorderFactory.createLineBorder(Color.black);
	        Container c=frame.getContentPane();
	        
	        // Creating a JPanel for the JFrame
	        jobInfoPanel=new JPanel();
	        timeCompletedPanel=new JPanel();
	        backButton = new JButton("Home");
	 		ActionListener listener1 = new BackListener();
	 		backButton.addActionListener(listener1);
	 		backButton.setBounds(495, 410, 100, 25);
	 		
	 		// Job Instructions
	 		jobInstructions= new JLabel("Jobs Completed:");
	 		jobInstructions.setBounds(120, 50, 200, 50);
	 		jobInfoPanel.add(jobInstructions);
	 		
	 		// Time Completed 
	 		timeInstructions = new JLabel("Completion Time:");
	 		timeInstructions.setBounds(120,50,200,50); 
	 		timeCompletedPanel.add(timeInstructions);
	 		
	        // setting the panel layout as null
	        jobInfoPanel.setLayout(new BoxLayout(jobInfoPanel, BoxLayout.Y_AXIS));
	        timeCompletedPanel.setLayout(new BoxLayout(timeCompletedPanel, BoxLayout.Y_AXIS));
	        joblabel = new JLabel();
	        
	        List<Job> jobList = FileReader.Job("SavedInfo/JobInfo.txt");
			for (int i = 0; i < jobList.size(); i++)
			{
				// tester.queueAdd(jobList.get(i));
				// tester.getCompletionTime(jobList.get(i));
				joblabel=new JLabel(jobList.get(i).toString());
				jobInfoPanel.add(joblabel);
				joblabel.setBounds(120,150,200,50);
			}
			
			frame.add(backButton);
			
	        // adding a label element to the panel
			timeLabel= new JLabel();
			finalTime = new JLabel();
	        FIFOTest tester = new FIFOTest();
			for (int i = 0; i < jobList.size(); i++)
			{
				int sum = 0;
				tester.queueAdd(jobList.get(i));
				int completion = tester.getCompletionTime(jobList.get(i));
				String completeTime = Integer.toString(completion);
				timeLabel=new JLabel("  "+completeTime);
				timeCompletedPanel.add(timeLabel);
				timeLabel.setBounds(120,50,200,50);
				for (int j = 0; j < jobList.size(); j++)
				{
					sum += jobList.get(j).getJobDuration();
				}
				finalTime.setText("FINAL TIME: " + sum);
				timeCompletedPanel.add(finalTime);
			}
			
			
			
	        // Panel 1
	        jobInfoPanel.setBackground(new Color(145,115,235));
	        jobInfoPanel.setBounds(10,10,600,200);
	        
	        //Panel
	        timeCompletedPanel.setBackground(new Color(216,180,237));
	        timeCompletedPanel.setBounds(10,230,600,200);
	        
	        // Panel border
	        jobInfoPanel.setBorder(br);
	        timeCompletedPanel.setBorder(br);
	        
	        //adding the panel to the Container of the JFrame
	        c.add(jobInfoPanel);
	        c.add(timeCompletedPanel);
	        
	        frame.setVisible(true);
	    }
	    
	    public class BackListener implements ActionListener {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		JComponent comp = (JComponent) event.getSource();
	    		Window win = SwingUtilities.getWindowAncestor(comp);
	    		win.dispose();
	    		new HomePage().new CloudControllerHome();
	    	}
	    }
	}
	
	public static void main(String[] args) {
		new FIFOTest().new completeTime();
	}
}
