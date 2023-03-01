import java.io.RandomAccessFile;
import java.io.IOException;


public class Arquivo_Java {
    private String nomearquivo;
    private RandomAccessFile arquivo;

    public Arquivo_Java(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public void truncate(long pos) //desloca eof
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }

    //semelhante ao feof() da linguagem C
    //verifica se o ponteiro esta no <EOF> do arquivo
    public boolean eof()  
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;                               
        } catch (IOException e)
        { }
        return (retorno);
    }
    public int filesize(){
        try{
            return (int)arquivo.length()/Registro.length();
        }
        catch(IOException e){
            return 0;
        }
    }
    //insere um Registro no final do arquivo, passado por par�metro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
            System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
    }

    public void leArq()
    {
        int codigo, idade;
        String nome;
        codigo = Entrada.leInteger("Digite o c�digo");
        while (codigo != 0)
        {
            nome = Entrada.leString("Digite o nome");
            idade = Entrada.leInteger("Digite a idade");
            inserirRegNoFinal(new Registro(codigo, nome, idade));
            codigo = Entrada.leInteger("Digite o c�digo");
        }
    }

    public Registro clone(Registro reg){
        return new Registro(reg.getCodigo(),reg.getNome(),reg.getIdade());
    }

    
    //.............................................................................
    /*

    insira aqui os m�todos de Ordena��o;
    */
    public void directSelectionArq(){
        int lower, pos, LS = filesize();
        Registro regI = new Registro(), regJ = new Registro();
        for(int i=0;i<LS-1;i++){
            seekArq(i);
            regI.leDoArq(arquivo);
            lower = regI.getCodigo();
            pos = i;
            for(int j=i+1;j<LS;j++){
                regJ.leDoArq(arquivo);
                if(regJ.getCodigo()<lower){
                    lower = regJ.getCodigo();
                    pos = j;
                }
            }
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(pos);
            regJ.leDoArq(arquivo);
            seekArq(i);
            regJ.gravaNoArq(arquivo);;
            seekArq(pos);
            regI.gravaNoArq(arquivo);;
        }
    }

    public void bubbleSortArq(){
        int LS = filesize();
        Registro reg1 = new Registro(), reg2 = new Registro();
        boolean flag = false;
        while(LS>1 && !flag){
            for(int i=0;i<LS-1;i++){
                flag = true;
                seekArq(i);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);
                if(reg1.getCodigo()>reg2.getCodigo()){
                    seekArq(i);
                    reg2.gravaNoArq(arquivo);
                    reg1.gravaNoArq(arquivo);
                    flag = false;
                }
            }
            LS--;
        }
    }
}
