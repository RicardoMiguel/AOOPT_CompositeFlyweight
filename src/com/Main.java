package com;

public class Main {

    public static void main(String[] args) {
        Document d=new Document();
        Chapter c=new Chapter();
        Paragraph p = new Paragraph("A simple paragraph. Build from 2 sentences."); //inside this constructor it must be converted to the collection of references to 'Character' objects and the RLE sequence.
        c.addParagraph(p);
        d.addChapter(c);

        System.out.println(d.print(new DocumentPartVisitor()));
    }
}
