package CommentsTask;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(";|\\n");


        int n = Integer.parseInt(scanner.nextLine().trim());
        Comment[] comments = new Comment[n];


        for (int i = 0; i < n; i++) {
            String name = scanner.next().trim();
            String comment = scanner.next().trim();
            int likesQty = Integer.parseInt(scanner.next().trim());

            comments[i] = new Comment(name, comment, likesQty);
        }
        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return Integer.compare(c2.getLikesQty(), c1.getLikesQty());
            }
        });
        for (Comment c : comments) {
            System.out.println(c.getName() + "#" + c.getComment() + "#" + c.getLikesQty());
        }

        Arrays.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        for (Comment c : comments) {
            System.out.println(c.getName() + "#" + c.getComment() + "#" + c.getLikesQty());
        }
    }

}
