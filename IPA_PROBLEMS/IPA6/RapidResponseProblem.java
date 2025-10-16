package IPA6;

import java.util.*;

class RRT {
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;

    public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project) {
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public int getPriority() {
        return priority;
    }

    public String getProject() {
        return project;
    }
}

public class RapidResponseProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RRT[] arr = new RRT[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new RRT(a, b, c, d, e);
        }

        String value = sc.nextLine();
        RRT ans = getHighestPriorityTicket(arr, value);
        if (ans != null) {
            System.err.println(ans.getTicketNo());
            System.err.println(ans.getRaisedBy());
            System.err.println(ans.getAssignedTo());
        } else {
            System.out.println("No such Ticket");
        }

    }

    public static RRT getHighestPriorityTicket(RRT[] arr, String value) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getProject().equalsIgnoreCase(value)) {
                min = Math.min(min, arr[i].getPriority());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPriority() == min) {
                return arr[i];
            }
        }

        return null;
    }
}
