class WordDictionary {
    class Node{
        Node[] children;
        boolean isWord;
        public Node(){
            children = new Node[26];
            isWord = false;
        }
    }

    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        for(char c : word.toCharArray()){
            if(p.children[c - 'a'] == null){
                p.children[c - 'a'] = new Node();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word,root,0);
    }
    private boolean searchHelper(String word, Node node, int i){
        // base case
        if(i >= word.length()) return node.isWord;
        if(word.length() == 0) return true;
        if(node == null) return false;
        char c = word.charAt(i);
        if( c == '.'){
            boolean found = false;
            for(Node child : node.children){
                if(child == null) continue;
                found = found || searchHelper(word,child,i + 1);
            }
            return found;
        }else{
            if(node.children[c - 'a'] == null) return false;
            return searchHelper(word,node.children[c - 'a'], i + 1);
        }
    }
}
