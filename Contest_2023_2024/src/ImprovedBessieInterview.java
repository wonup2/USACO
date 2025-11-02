import java.util.*;

public class ImprovedBessieInterview {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        boolean[] interviewerAvailable = new boolean[K]; // 면접 가능한 면접관 추적을 위한 배열

        for (int i = 0; i < K; i++) {
            queue.add(new long[]{0, i}); // 모든 면접관을 초기에 면접 가능 상태로 설정
            interviewerAvailable[i] = true;
        }

        long lastInterviewTime = 0; // Bessie의 면접 시작 시간
        for (int i = 0; i < N; i++) {
            long interviewTime = input.nextLong();
            long[] current = queue.poll();
            
            lastInterviewTime = current[0] + interviewTime; // 현재 면접관의 면접 시간 업데이트
            queue.add(new long[]{lastInterviewTime, current[1]});
        }

        // Bessie의 면접이 가능한 면접관 추적
        StringBuilder possibleInterviewers = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (interviewerAvailable[i]) possibleInterviewers.append('1');
            else possibleInterviewers.append('0');
        }

        System.out.println(lastInterviewTime); // Bessie의 면접 시작 시간 출력
        System.out.println(possibleInterviewers.toString()); // 면접 가능한 면접관 출력

        input.close();
    }
}
