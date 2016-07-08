package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class Chapter implements IDocumentPart {
    private List<IDocumentPart> chapterComposition;

    public Chapter() {
        chapterComposition = new ArrayList<>();
    }

    public void addParagraph(final Paragraph paragraph){
        chapterComposition.add(paragraph);
    }

    public List<IDocumentPart> getChapterComposition() {
        return chapterComposition;
    }

    @Override
    public String print(IDocumentPartVisitor iDocumentPartVisitor) {
        return iDocumentPartVisitor.print(this);
    }
}
