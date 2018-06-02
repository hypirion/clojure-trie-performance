package modulo.lotus.trie;

public class Trie {
    Trie[] children;
    int count;
    boolean terminates;

    public Trie() {
        children = new Trie[26];
        count = 0;
        terminates = false;
    }

    public void add(char[] cs) {
        add(cs, 0);
    }

    public int countFor(char[] cs) {
        Trie cur = this;
        for (char c : cs) {
            Trie next = cur.children[charIndex(c)];
            if (next == null) {
                return 0;
            }
            cur = next;
        }
        return cur.count;
    }

    static int charIndex(char c) {
        return c - 'a';
    }

    boolean add(char[] cs, int idx) {
        if (cs.length == idx) {
            boolean alreadyTerminated = terminates;
            terminates = true;
            if (!alreadyTerminated) {
                count++;
            }
            return alreadyTerminated;
        }
        boolean alreadyTerminated = childFor(cs[idx]).add(cs, idx+1);
        if (!alreadyTerminated) {
            count++;
        }
        return alreadyTerminated;
    }

    Trie childFor(char c) {
        Trie child = children[charIndex(c)];
        if (child == null) {
            child = new Trie();
            children[charIndex(c)] = child;
        }
        return child;
    }
}
