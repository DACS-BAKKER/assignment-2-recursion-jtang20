import java.util.*;

public class EveryVoteCounts {
    public static void main(String args[]) {
        Scanner sam = new Scanner(System.in);
        ArrayList<Integer> blocks = new ArrayList<Integer>();
        int blockIndex;
        while (true) {
            System.out.print("Enter vote blocks (enter 0 when finished): ");
            int num = sam.nextInt();
            if (num == 0) {
                break;
            }
            blocks.add(num);
        }
        while (true) {
            System.out.println("Enter block index (starting at 0): "); //count critical votes for block with index
            blockIndex = sam.nextInt();
            if (blockIndex < blocks.size()) {
                break;
            }
        }
        int votes = CountCriticalVotes(blocks, blockIndex);
        System.out.println("Block index " + blockIndex + " has " + votes + " critical votes.");
    }

    public static int CountCriticalVotes(ArrayList<Integer> blocks, int blockIndex) { //wrapper method
        int vote = blocks.get(blockIndex);
        blocks.remove(blockIndex);
        int count = 0;
        int index = 0;
        int sum = 0;

        int totalVotes = 0;
        for (int i = 0; i <= blocks.size()-1; i++) {
            totalVotes += blocks.get(i);
        }
        System.out.println(totalVotes);
        return RecVote(blocks, index, sum, count, vote, totalVotes);
    }

    public static int RecVote(ArrayList<Integer> blocks, int index, int sum, int count, int vote, int totalVotes) { //recursive method
        if (index <= blocks.size()) {
            int candidateA = sum;
            int candidateB = totalVotes - sum;
            if ((candidateB > candidateA && candidateA + vote > candidateB) || (candidateA > candidateB && candidateB + vote > candidateA)) {
                count++;
                return count;
            }
        }

        RecVote(blocks, index + 1, sum + blocks.get(index), count, vote, totalVotes); //vote for A
        RecVote(blocks, index + 1, sum, count, vote, totalVotes); // vote for B
        return count;
    }
}
