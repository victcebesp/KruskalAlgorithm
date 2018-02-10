public class Sorter {

    public void sort(Edge[] edges) {

        int m11 = 1;
        int length = edges.length;
        Edge[] aux = new Edge[length];

        while(m11 < length){

            int p1 = 0;
            int l1 = p1 + m11;
            int p2 = l1;
            int l2 = p2 + m11;
            int pla = 0;

            while( pla < length){

                if(l1 > length-1) l1 = length;

                if( l2 > length-1) l2 = length;

                while(p1 < l1 && p2 < l2){

                    if(edges[p1].getCost() < edges[p2].getCost()) aux[pla] = edges[p1++];
                    else aux[pla] = edges[p2++];
                    pla++;
                }

                while(p1 < l1) aux[pla++] = edges[p1++];
                while(p2 < l2) aux[pla++] = edges[p2++];
                
                p1 = p2;
                l1 = p2 + m11;
                p2 = l1;
                l2 = p2 + m11;
            }

            m11 = 2 * m11;
            System.arraycopy(aux, 0, edges, 0, length);
        }
    }

}
