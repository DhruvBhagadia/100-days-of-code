    boolean checkIfAllAreSmall(Node node, int val) {
        if(node == null)
            return true;
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){
                Node temp = q.remove();
                if(temp.data >= val)
                    return false;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            return true;
        }
    }

    boolean checkIfAllAreGreater(Node node, int val) {
        if(node == null)
            return true;
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){
                Node temp = q.remove();
                if(temp.data <= val)
                    return false;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            return true;
        }
    }

    boolean checkBST(Node root) {
        if(root == null)
            return true;
        else if(root.left == null && root.right == null){
            return true;
        }
        else {
            boolean left = true;
            boolean check_left = true;
            boolean right = true;
            boolean check_right = true;
            if(root.left != null){
                left = checkIfAllAreSmall(root.left, root.data);
                check_left = checkBST(root.left);
            }
            if(root.right != null){
                right = checkIfAllAreGreater(root.right, root.data);
                check_right = checkBST(root.right);
            }
            if(!left || !check_left || !right || !check_right)
                return false;
            return true;
        } 
    }
