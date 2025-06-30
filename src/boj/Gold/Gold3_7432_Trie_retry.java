package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold3_7432_Trie_retry {
    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
    }

    static class Trie {
        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        void insert(String path) {
            TrieNode node = root;
            for (String directory : path.split("\\\\")) {
                if (!node.children.containsKey(directory)) {
                    node.children.put(directory, new TrieNode());
                }
                node = node.children.get(directory);
            }
        }

        void print(TrieNode node, int depth) {
            for (String dir : node.children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append(" ");
                }
                sb.append(dir).append("\n");
                print(node.children.get(dir), depth + 1);
            }
        }

        void print() {
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String path = br.readLine();
            trie.insert(path);
        }

        trie.print(trie.root, 0);
        trie.print();
    }
}
