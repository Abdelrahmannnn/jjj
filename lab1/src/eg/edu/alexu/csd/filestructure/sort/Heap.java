package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Collection;

public class Heap<T extends Comparable<T>> implements IHeap {
    private INode left;
    private INode right;
    private INode largest;
    private INode swap;
    private INode temp;
    private INode temp2 ;
    ArrayList<INode> unordered = new ArrayList();
    private int index;
    private int lastPosititon = 1;
    private int position =1;
    private int a, b,c;

    //public Heap(ArrayList unordered) {
       // for (int i=0;i<unordered.size();i++){
           // INode s=new Node();
            //s.setValue((Comparable) unordered.get(i));
           // this.unordered.add(i,s);
        //}
    //}
    public Heap() {
        unordered.add(null) ;
    }

    /*public static  Heap ob=new Heap();
    public static Heap getInst() {
        if(ob==null) {
            return new Heap();
        }
        return ob;
    }*/

    @Override
    public INode getRoot() {
        if(this.unordered.size()==1){
            return  null ;
        }
        return this.unordered.get(1);
    }

    @Override
    public int size() {
        return this.unordered.size()-1;
    }

    @Override
    public void heapify(INode node) {
        if(node==null){
            return;
        }
        if (node.getLeftChild() == null) {
            return;
        }
        if(node.getRightChild()==null){
            return;
        }
        left = node.getLeftChild();
        right = node.getRightChild();

        for (int i = 1; i < this.unordered.size(); i++) {
            if (this.unordered.get(i).getValue().equals(node)) {
                index = i;
            }
        }
        if (left.getValue().compareTo(node.getValue()) > 0) {
            largest = left;
        } else {
            largest = node;
        }
        if (right.getValue().compareTo(largest.getValue()) > 0) {
            largest = right;
        }
        for (int i = 1; i < this.unordered.size(); i++) {
            if (this.unordered.get(i).getValue().equals(largest)) {
                b = i;
            }
        }
        a = index;
        if (a != b) {
            swap = largest;
            this.unordered.remove(b);
            this.unordered.add(b, node);
            this.unordered.remove(a);
            this.unordered.add(a, swap);
            heapify(largest);
        }
    }


    @Override
    public Comparable extract() {
        if(this.unordered.size()==1){
            return  null ;
        }
        build(this.unordered);
        temp=this.unordered.get(1);
        this.unordered.remove(1);
        this.unordered.add(1,this.unordered.get(this.unordered.size()-1));
        this.unordered.remove(this.unordered.size()-1);
        if(this.unordered.size()!=1) {
            temp2 = this.unordered.get(1);
            heapify(temp2);
        }
        return  temp.getValue();
    }

    /*private void trickleDown(int parent) {
        if (parent * 2 + 1 == lastPosititon && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 1)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 1));
            this.unordered.remove(parent*2+1);
            this.unordered.add(parent*2+1, swap);
            return;
        }
        if (parent * 2 + 2 == lastPosititon && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 2)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 2));
            this.unordered.remove(parent*2+2);
            this.unordered.add(this.unordered.indexOf(parent * 2 + 2), swap);
            return;
        }
        if (parent * 2 + 1 >= lastPosititon || parent * 2 + 2 >= lastPosititon) {
            return;
        }
        if ((int) this.unordered.get(parent * 2 + 1) > (int) this.unordered.get(parent * 2 + 2) && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 1)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 1));
            this.unordered.remove(parent*2+1);
            this.unordered.add(parent * 2 + 1, swap);
            trickleDown(parent * 2 + 1);
        } else if ((int) this.unordered.get(parent * 2 + 2) > (int) this.unordered.get(parent * 2 + 1) && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 2)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 2));
            this.unordered.remove(parent*2+2);
            this.unordered.add(parent * 2 + 2, swap);
            trickleDown(parent * 2 + 2);
        }
    }*/

    @Override
    public void insert(Comparable element) {
        if(element==null){
            return;
        }
        //build(this.unordered);
        //lastPosititon = this.unordered.size() - 1;
        Node n = new Node(unordered);
        n.setIndex(lastPosititon);
        n.setValue(element);
        this.unordered.add(lastPosititon,n);
        lastPosititon++ ;
        //e.arr.add(n) ;
        trickleUp(lastPosititon-1);

    }

    private void trickleUp(int lastPosititon) {
        if (lastPosititon == 1) {
            return;
        }

       // INode K = new Node();
        //K.setValue(this.unordered.get(lastPosititon));
        Node child = (Node) this.unordered.get(lastPosititon);
        //int num = child.getIndex() ;
        //INode child = K;
        Node parent = (Node)child.getParent();
        if (child.getValue().compareTo(parent.getValue()) > 0) {
            swap = child;
            this.unordered.remove(lastPosititon);
            this.unordered.add(lastPosititon, parent);
           for (int i = 1; i < this.unordered.size(); i++) {
                if (this.unordered.get(i).equals(parent.getValue())) {
                    c = i;
                }
            }
            c=parent.getIndex() ;
            this.unordered.remove(c);
            this.unordered.add(c, swap);
            int l = lastPosititon;
            l=l/2;
            trickleUp(l);

        }
        return;
    }




    @Override
    public void build(Collection unordered) {
        if(unordered==null){
            return;
        }
        /*for (int j = 0; j < unordered.size() ; j++) {
            this.unordered.add(j, (INode) unordered.iterator().next());
        }*/
        for (int i = (this.unordered.size() / 2); i > 0; i--) {
            heapify(this.unordered.get(i));
        }
        for(int i = this.unordered.size()-1;i>0;i--){
            heapify(this.unordered.get(i));
            // MOMKN swap
        }
    }

    public void make(T val){
        Node l = new Node(this.unordered) ;
        l.setValue(val);
        l.setIndex(position);
        this.unordered.add(position,l);
        position++ ;
    }
}
