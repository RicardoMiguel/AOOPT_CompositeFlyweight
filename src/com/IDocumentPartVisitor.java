package com;

/**
 * Created by Ricardo on 22/06/2016.
 */
public interface IDocumentPartVisitor {
    public String print(Document e);
    public String print(Chapter e);
    public String print(Paragraph e);
    public String print(Character e, boolean upperCase);
}
