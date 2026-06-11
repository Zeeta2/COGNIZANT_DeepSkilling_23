package factoryMethodPatternExample;


interface Document{
    void open();
}
class WordDocument implements Document{
    public void open(){
        System.out.println("Opening word document");
    }
}
class PdfDocument implements Document{
    public void open(){
        System.out.println("Opening pdf document");
    }
}
class ExcelDocument implements Document{
    public void open(){
        System.out.println("Opening excel document");
    }
}



abstract class Documentfactory{
    abstract Document createDocument();
}
class WordDocumentFactory extends Documentfactory{
    Document createDocument(){
        return new WordDocument();
    }
}
class PdfDocumentFactory extends Documentfactory{
    Document createDocument(){
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends Documentfactory{
    Document createDocument(){
        return new ExcelDocument();
    }
}





public class Main {
    public static void main(String[] args) {
        Documentfactory wf = new WordDocumentFactory();
        Document w = wf.createDocument();
        w.open();
        Documentfactory pf = new PdfDocumentFactory();
        Document p = pf.createDocument();
        p.open();
        Documentfactory ef = new ExcelDocumentFactory();
        Document e = ef.createDocument();
        e.open();



    }
}