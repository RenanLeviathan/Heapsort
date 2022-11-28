package alg;

public class Heapsort {
    private final int A[];
    private int tempo = 0;
    private int heap;

    public void troca(int i, int j){
        int aux = A[i];
        tempo++;
        A[i] = A[j];
        tempo++;
        A[j] = aux;
        tempo++;
    }
    public Heapsort(int[] A){
        this.A = A;
    }

    public void maxHeapify(int[] A, int i){
        int l = 2*i;
        tempo += 1;
        int r = 2*i + 1;
        tempo += 1;
        int maior;
        tempo ++;
        if (l < heap && A[l] > A[i]) {
            maior = l;
            tempo++;
        } else {
            maior = i;
            tempo++;
        }
        if (r < heap && A[r] > A[maior]) {
            maior = r;
            tempo++;
        }
        if (maior != i) {
            troca(i, maior);
            maxHeapify(A, maior);
        }
    }

    public void buildMaxHeap(){
        heap = A.length;
        tempo += 1;
        for(int i=A.length/2; i>=0;i--){
           maxHeapify(A, i);
        }
    }

    public void sort(){
        buildMaxHeap();
        for(int i=heap;i>0;i--){
            troca(0,heap-1);
            heap--;
            tempo+=1;
            maxHeapify(A,0);
        }
    }

    @Override
    public String toString(){
        String s = "{";
        for (int j : A) {
            s += j + ",";
        }
        s = s.substring(0,s.length()-1);
        s += "}";
        return s;
    }

    public void exibirTempo(){
        System.out.println("Tempo de execução: "+tempo+"ms");
    }
}
