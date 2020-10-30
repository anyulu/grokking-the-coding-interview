import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        // TODO: Write your code here
        List<int[]> data = new ArrayList<>();
        for (Job job: jobs) {
            data.add(new int[]{job.start, job.cpuLoad});
            data.add(new int[]{job.end, -job.cpuLoad});
        }
        Collections.sort(data, (a,b)-> {return a[0]-b[0];});
        int max = 0;
        int curr = 0;
        for (int[] used: data) {
            curr += used[1];
            if (used[1] > 0) max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
