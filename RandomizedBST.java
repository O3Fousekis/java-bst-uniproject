import java.util.List;

class RandomizedBST implements TaxEvasionInterface {
    private class TreeNode {
        LargeDepositor item;
        TreeNode left;
        TreeNode right;
        int N; // number of nodes in the subtree rooted at this TreeNode

    }

    private TreeNode root; //tree root

    public RandomizedBST() {
        this.root = null;
    }

    public void insert(LargeDepositor item) {
        root = insertAsRoot(item, root);
        
    }

    public TreeNode insertAsRoot(LargeDepositor item, TreeNode h) {

        if (h == null) {
            TreeNode tempn = new TreeNode();
            tempn.item = item;
            tempn.N = 1;
            return tempn;

        }

        if (item.key() == h.item.key()) {
            System.out.println("Depositor with AFM:" + item.key() + " already exists.");
            throw new IllegalStateException("Depositor with duplicate AFM.");

        } else {
            double prob = 1.0 / (h.N +1);

            if (Math.random() < prob) {
                TreeNode tempn = new TreeNode();
                tempn.item = item;
                tempn.N = h.N + 1;

                if (Math.random() < h.left.N / tempn.N) {
                    tempn.left = h.left;
                    tempn.right = h.right;
                } else {
                    tempn.left = insertAsRoot(item, h);
                    tempn.right = h.right;
                }

                return tempn;

            } else if (item.key() < h.item.key()) {
                h.left = insertAsRoot(item, h);

            } else {
                h.right = insertAsRoot(item,h);

            }
            
            h.N = h.left.N + h.right.N + 1;

            return h;
        }

    }

    public void load(String filename) {

        
        
    }

    public void updateSavings(int AFM, double savings) {

    }

    public LargeDepositor searchByAFM(int AFM) {

    }

    public List searchByLastName(String last_name) {

    }
    
    public void remove(int AFM) {

    }

    public double getMeanSavings() {

    }

    public void printTopLargeDepositors(int k) {

    }

    public void printByAFM() {
        
    }
}