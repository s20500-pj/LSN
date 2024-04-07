import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> connections = readMapFromFile("input.txt");
        List<List<Integer>> graphs = new ArrayList<>();

        if (Objects.isNull(connections)) {
            return;
        }

        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            boolean added = false;
            for (List<Integer> graph : graphs) {
                if (Objects.equals(entry.getKey(), graph.get(graph.size() - 1))) {
                    graph.add(entry.getValue());
                    added = true;
                    break;
                } else if (Objects.equals(entry.getValue(), graph.get(0))) {
                    graph.add(0, entry.getKey());
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<Integer> newGraph = new ArrayList<>();
                newGraph.add(entry.getKey());
                newGraph.add(entry.getValue());
                graphs.add(newGraph);
            }
        }

        System.out.println(graphs.size());
    }

    public static Map<Integer, Integer> readMapFromFile(String filename) {
        Map<Integer, Integer> map = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            int numberOfPairs = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberOfPairs; i++) {
                String line = scanner.nextLine();
                String[] pair = line.split(" ");
                int key = Integer.parseInt(pair[0]);
                int value = Integer.parseInt(pair[1]);
                map.put(key, value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filename);
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in file.");
            return null;
        }

        return map;
    }
}