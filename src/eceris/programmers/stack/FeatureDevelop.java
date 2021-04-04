package eceris.programmers.stack;

import java.util.*;
// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
public class FeatureDevelop {

    public static void main(String args[]) {

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};


        Queue<Job> jobs = getJobs(progresses, speeds);



        int count = 0;
        while (!jobs.isEmpty()) {
            count++;


            Job peek = jobs.peek();
            if (peek.getProgress() + peek.getSpeed()*count > 100) {
                jobs.poll();
                jobs.peek();
            }
        }



    }


    private static Queue<Job> getJobs(int[] progresses, int[] speeds) {
        Queue<Job> jobs = new LinkedList<>();
        for (int i = 0; i< progresses.length; i++) {
            jobs.add(new Job(progresses[i], speeds[i]));
        }
        return jobs;
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }








    public static class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public int getProgress() {
            return progress;
        }

        public int getSpeed() {
            return speed;
        }
    }
}
