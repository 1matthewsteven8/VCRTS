/* Project Milestone 4: Implementation
* Class: Job.java
* Author: Matthew Lardi
* Due: October 25, 2022
* This class is used to create objects pertaining to an individual Job and stores the
* specific ID, Name, Duration, and Information for each job in question. 
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class Job {

	private int jobID;
	private int jobDuration;
	private String jobName;
	private String jobInfo;
	
	final int FrameWidth = 620;
	final int FrameHeight = 400;

	public Job() {
	}

	public Job(int jobID, int jobDuration, String jobName, String jobInfo) {
		this.jobID = jobID;
		this.jobDuration = jobDuration;
		this.jobName = jobName;
		this.jobInfo = jobInfo;
	}

	public Job(int jobID, String name, int jobDuration) {
		this.jobID = jobID;
		this.jobName = name;
		this.jobDuration = jobDuration;
	}

	// sets the JobID of a job
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	// returns the Job of the specified job
	public int getJobID() {
		return jobID;
	}

	// sets the duration of a job
	public void setJobDuration(int jobDuration) {
		this.jobDuration = jobDuration;
	}

	// returns the duration of the specified job
	public int getJobDuration() {
		return jobDuration;
	}

	// sets the name of a job
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	// returns the name of the specified job
	public String getJobName() {
		return jobName;
	}

	// sets the information of a job
	public void setJobInfo(String jobInfo) {
		this.jobInfo = jobInfo;
	}

	// returns a String of the information of the specified job
	public String getJobInfo() {
		return jobInfo;
	}

	public String toString() {
		String output = "\n Job ID: " + this.getJobID() + "\n Job Duration: " + this.getJobDuration() + "\n Job Name: "
				+ this.getJobName() + "\n Job Info: " + this.getJobInfo();
		return output;
	}

	public Job findByName(String id) {
		List<Job> jobList = associate();
		for (Job car : jobList) {
			if (car.getJobName().equals(id)) {
				return car;
			}
		}
		return null;
	}

	public List<Job> associate() {
		ArrayList<Job> associate = new ArrayList<Job>();
		Job job1 = new Job(1, "upload document", 5);
		Job job2 = new Job(2, "upload picture", 10);
		Job job3 = new Job(3, "upload file", 15);

		associate.add(job1);
		associate.add(job2);
		associate.add(job3);

		return associate;
	}

	public class JobViewer {
		// int[] jobID = new int[5];
		// jobID[] = {1,2,3,4,5,6};
		int[] jobID = { 1, 2, 3 };
		int[] jobDuration = { 5, 10, 15 };
		String[] jobName = { "upload document", "upload picture", "upload file" };

		private JFrame frame;
		private JPanel mainpanel;
		private JLabel instructions, JobID, JobName, JobInfo, timeMin, savedMessage;
		private JTextField inID, inInfo, inMinutes;
		private JButton submitJob, backButton;
		private JComboBox jobMenu;

		public JobViewer() {
			frame = new JFrame();
			mainpanel = new JPanel();
			instructions = new JLabel(
					"<html>Here you can submit a job. Please enter the job information. Click the submit button once you are finished.</html>");
			Font font = new Font("Times New Roman", Font.BOLD, 16);
			instructions.setFont(font);
			JobID = new JLabel("Job ID");
			inID = new JTextField(6);
			JobID.setFont(new Font("Times New Roman", Font.BOLD, 14));
			JobName = new JLabel("Job Name");
			JobName.setFont(new Font("Times New Roman", Font.BOLD, 14));
			JobInfo = new JLabel("Job Info");
			inInfo = new JTextField(40);
			JobInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
			timeMin = new JLabel("Job Duration");
			inMinutes = new JTextField(4);
			timeMin.setFont(new Font("Times New Roman", Font.BOLD, 14));
			submitJob = new JButton("Submit");
			backButton = new JButton("Back");
			savedMessage = new JLabel("");
			frame.setSize(640, 360);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Job Submission");
			frame.add(mainpanel);
			mainpanel.setLayout(null);
			instructions.setBounds(10, 10, 620, 35);
			mainpanel.add(instructions);
			JobID.setBounds(190, 110, 100, 25);
			inID.setBounds(300, 110, 155, 25);
			mainpanel.add(JobID);
			mainpanel.add(inID);
			JobName.setBounds(190, 70, 100, 25);
			mainpanel.add(JobName);
			JobInfo.setBounds(190, 155, 100, 25);
			inInfo.setBounds(300, 155, 155, 25);
			mainpanel.add(JobInfo);
			mainpanel.add(inInfo);
			timeMin.setBounds(190, 200, 100, 25);
			inMinutes.setBounds(300, 200, 155, 25);
			mainpanel.add(timeMin);
			mainpanel.add(inMinutes);
			submitJob.setBounds(190, 250, 100, 25);
			ActionListener listener = new submitJobListener();
			submitJob.addActionListener(listener);
			mainpanel.add(submitJob);
			backButton.setBounds(355, 250, 100, 25);
			backButton.addActionListener(new backButton());
			mainpanel.add(backButton);
			savedMessage.setBounds(50, 250, 150, 100);
			mainpanel.add(savedMessage);
			mainpanel.setBackground(new Color(122, 111, 150));

			jobMenu = new JComboBox(jobName);
			jobMenu.setBounds(295, 70, 170, 25);
			// (300, 110, 155, 25);
			mainpanel.add(jobMenu);
			ActionListener listener1 = new menuListener();
			jobMenu.addActionListener(listener1);
			frame.setVisible(true);
			inID.setText("");
			inMinutes.setText("");
			inInfo.setText("");
		}

		public class menuListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (jobMenu.getSelectedItem().equals("upload document")) {
					String jobN = (String) jobMenu.getSelectedItem();
					// String jobN = "Job1";
					Job testJob = new Job();
					List<Job> jobList = associate();
					for (Job job : jobList) {
						if (job.getJobName().equals(jobN)) {
							testJob.findByName(jobN);
							testJob.setJobID(job.getJobID());
							testJob.setJobName(jobN);
							testJob.setJobDuration(job.getJobDuration());
							int id = testJob.getJobID();
							String idx = Integer.toString(id);
							inID.setText(idx);
							int min = testJob.getJobDuration();
							String minx = Integer.toString(min);
							inMinutes.setText(minx);
						}
					}

					System.out.println(testJob); // fileWriter here
				} else if (jobMenu.getSelectedItem().equals("upload picture")) {
					String jobN = (String) jobMenu.getSelectedItem();
					// String jobN = "Job1";
					Job testJob = new Job();
					List<Job> jobList = associate();
					for (Job job : jobList) {
						if (job.getJobName().equals(jobN)) {
							testJob.findByName(jobN);
							testJob.setJobID(job.getJobID());
							testJob.setJobName(jobN);
							testJob.setJobDuration(job.getJobDuration());
							int id = testJob.getJobID();
							String idx = Integer.toString(id);
							inID.setText(idx);
							int min = testJob.getJobDuration();
							String minx = Integer.toString(min);
							inMinutes.setText(minx);
						}
					}

					System.out.println(testJob); // fileWriter here
				} else if (jobMenu.getSelectedItem().equals("upload file")) {
					String jobN = (String) jobMenu.getSelectedItem();
					// String jobN = "Job1";
					Job testJob = new Job();
					List<Job> jobList = associate();
					for (Job job : jobList) {
						if (job.getJobName().equals(jobN)) {
							testJob.findByName(jobN);
							testJob.setJobID(job.getJobID());
							testJob.setJobName(jobN);
							testJob.setJobDuration(job.getJobDuration());
							int id = testJob.getJobID();
							String idx = Integer.toString(id);
							inID.setText(idx);
							int min = testJob.getJobDuration();
							String minx = Integer.toString(min);
							inMinutes.setText(minx);
						}
					}

					System.out.println(testJob); // fileWriter here
				}
			}
		}

		public class submitJobListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int newJobID = Integer.parseInt(inID.getText());
				String newJobName = (String) jobMenu.getSelectedItem();
				int newTimeMin = Integer.parseInt(inMinutes.getText());
				String newJobInfo = inInfo.getText();
				Timestamp time = new Timestamp(System.currentTimeMillis());
				Job newJob = new Job(newJobID, newTimeMin, newJobName, newJobInfo);
				System.out.println(newJob.getJobInfo());

				/*
				 * List<Job> ownerList = FileReader.Job("SavedInfo\\JobInfo.txt"); <---- I
				 * couldn't get this to work for (Job jobs: ownerList) { String tempID =
				 * jobs.getJobID() + ""; if (tempID.equals(inID.getText())) {
				 * System.out.println("Job ID already in use!"); return; } }
				 */

				// --------------------------------------------------
				// Added a file printer that stores vehicle information
				File file = new File("SavedInfo/JobInfo.txt"); // create new file where info will be stored
				file.getParentFile().mkdirs(); // use getParentFile().mkdirs() to have location where file is stored
												// created
				// automatically if it does not exist

				// catch exception when printing into file
				try {
					PrintWriter fileWriter = new PrintWriter(new FileWriter(file, true)); // create writer
					fileWriter.println();
					fileWriter.print(newJobID + " "); // get information inputed into program and print into file
					fileWriter.print(newJobName + " ");
					fileWriter.print(newTimeMin + " ");
					fileWriter.print(newJobInfo + " ");
					fileWriter.print(time);
					fileWriter.flush();
					fileWriter.close(); // flush and close writer
					System.out.println("Job information stored"); // print into console when info was saved into file
				} catch (IOException k) {
					k.printStackTrace();
				}

				inID.setText("");
				inMinutes.setText("");
				inInfo.setText("");
				savedMessage.setText("<html>The job has been submitted.</html>");
			}
		}

		public class backButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomePage().new ClientHome();
			}
		}

	}

	public static void main(String[] args) {
		JobViewer viewer = new Job().new JobViewer();
	}
}
