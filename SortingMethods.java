public class SortingMethods {

    public int vet[];
    public void directInsertion(int LS){
        int i = 1 , aux , pos;

        while(i<LS){
            aux = vet[i];
            pos = i;
            while(pos > 0 && aux < vet[pos-1]){
                vet[pos] = vet[pos-1];
                pos--; 
            }
            vet[pos] = aux;
            i++;
        }
    }

    public void listDirectInsertion(List list){
        Node i = list.getBegin().getNext(), pos;
        int aux;
        while(i!=null){
            pos = i;
            aux = pos.getInfo();
            while(pos != list.getBegin() && aux < pos.getPrev().getInfo()){
                pos.setInfo(pos.getPrev().getInfo());
                pos = pos.getPrev();
            }
            pos.setInfo(aux);
            i = i.getNext();
        }
    }

    public int binarySearch( int LS, int key){
        int begin=0,end=LS-1,mid=end/2;
        while(end>begin && key!=vet[mid]){
            if(key>vet[mid])
                begin = mid+1;
            else
                end = mid-1;
            mid = (end-begin)/2;
        }
        if(key>vet[mid])
            return mid+1;
        return mid;
    }

    public Node listBinarySearch(Node begin, Node end, int key){
        Node mid;
        int endPos = getEndPosition(begin,end)-1, beginPos = 0, midPos = endPos/2;
        mid = setMid(begin, midPos);
        while(end.getInfo()>begin.getInfo()&&key!=mid.getInfo())
        {
            if(key>mid.getInfo()){
                begin = mid.getNext();
                beginPos = midPos+1;
            }
            else{
                end = mid.getPrev();
                endPos = midPos-1;
            }
            midPos = (endPos+beginPos)/2;
            mid = setMid(begin,midPos);
        }
        if(key>mid.getInfo())
            return mid.getNext();
        return mid;
    }

    public void listBinaryInsertion(List list){
        Node pos, i, j;
        int aux;
        for(i=list.getBegin().getNext();i!=list.getEnd();i=i.getNext()){
            aux = i.getInfo();
            pos = listBinarySearch(list.getBegin(),i, aux);
            for(j=i;j!=pos;j=j.getNext())
                j.setInfo(j.getPrev().getInfo());
            pos.setInfo(aux);
        }

    }

    public Node setMid(Node begin, int midPos)
    {
        Node aux = begin;
        while(midPos>0){
            aux = aux.getNext();
            midPos--;
        }
        return aux;
    }
    public void binaryInsertion(int LS){
        int aux, pos;
        for(int i=1; i<LS;i++){
            aux = vet[i];
            pos = binarySearch(i, aux);
            for(int j=i;j<pos;j++)
                vet[j] = vet[j-1];
            vet[pos] = aux;
        }
    }

    public int getEndPosition(Node begin,Node end){
        int count=0;
        Node aux = end;
        while(aux!=begin){
            aux = aux.getPrev();
            count++;
        }
        
        return count;
    }

    public void directSelection(int LS){
        int lower,pos;
        for(int i=0;i<LS-1;i++){
            lower = vet[i];
            pos = i;
            for(int j=i+1;j<LS;j++)
                if(vet[j]<lower)
                {
                    lower = vet[j];
                    pos = j;
                }
            vet[pos] = vet[i];
            vet[i] = lower;
        }
    }

    public void listDirectSelection(List list){
        Node i, j, pos;
        int lower;
        for(i=list.getBegin();i!=list.getEnd();i=i.getNext()){
            lower = i.getInfo();
            pos = i;
            for(j=i.getNext();j!=null;j=j.getNext())
                if(j.getInfo()<lower)
                {
                    lower = j.getInfo();
                    pos = j;
                }
            pos.setInfo(i.getInfo());
            i.setInfo(lower);
        }
    }

    public void bubbleSort(int LS){
        int aux, LS2 = LS;
        boolean flag = false;
        while(LS2>1 && !flag){
            for(int i=0;i<LS2 ;i++){
                flag = true;
                if(vet[i]>vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                    flag = false;
                }
            }
            LS2--;
        }
    }

    public void shakeSort(int LS){
        int begin=0, end = LS-1, aux;
        while(begin<end){
            for(int i=begin;i<end;i++){
                if(vet[i]>vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                }
            }
            end--;
            for(int i=end;i>begin;i--){
                if(vet[i]<vet[i-1]){
                    aux = vet[i];
                    vet[i] = vet[i-1];
                    vet[i-1] = aux;
                }
            }
            begin++;
        }
    }

    public void heapSort(int TL){
        int TL2=TL, pai, FE, FD, maiorF, aux;
        while(TL2>1){
            pai = TL2/2 - 1;
            while(pai>0){
                FE = 2*pai + 1;
                FD = FE + 1;
                maiorF = FE;
                if(FD < TL2 && vet[FD]>vet[FE])
                    maiorF = FD;

                if(vet[maiorF]>vet[pai]){
                    aux = vet[pai];
                    vet[pai]=vet[maiorF];
                    vet[maiorF]=aux;
                }
                pai--;
            }
            aux = vet[0];
            vet[0] = vet[TL2-1];
            vet[TL2-1] = aux;
            TL2--;
        }
    }

    public void shellSort(int TL, int dist){
        int aux;
        while(dist>0){
            for(int i=0;i<dist;i++){
                for(int j=i;j+dist<TL;j+=dist){
                    if(vet[j]>vet[j+dist]){
                        aux = vet[j];
                        vet[j] = vet[j+dist];
                        vet[j+dist] = aux;

                        for(int k=j;k-dist>=0 && vet[k]<vet[k-dist];k-=dist){
                                aux = vet[k-dist];
                                vet[k-dist] = vet[k];
                                vet[k] = aux;
                        }
                    }
                }
            }
            dist/=2;
        }
    }

    public void quickSort(int TL){
        quickSortPL(0, TL-1);
    }

    public void quickSortPL(int ini, int fim){
        int i = ini, j = fim, aux;
        while(i<j){
            while(i<j&&vet[i]<=vet[j])
                i++;
            aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
            while(i<j&&vet[j]>=vet[i])
                j--;
            aux = vet[j];
            vet[j] = vet[i];
            vet[i] = aux;
        }
        if(ini<i-1)
            quickSortPL(ini, i-1);
        if(j+1<fim)
            quickSortPL(j+1, fim);        
    }

    public void quickSortPLF(int ini, int fim){
        int i = ini, j = fim, aux;
        boolean flag = true;
        while(i<j){
            if(flag)
                while(i<j&&vet[i]<=vet[j])
                    i++;
            else
                while(i<j&&vet[j]>=vet[i])
                    j--;
            aux = vet[j];
            vet[j] = vet[i];
            vet[i] = aux;
            flag = !flag;
        }
        if(ini<i-1)
            quickSortPLF(ini, i-1);
        if(j+1<fim)
            quickSortPLF(j+1, fim);        
    }
}