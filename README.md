# Composite + Flyweight

Write a class hierarchy that can be used to represent an internal document structure (classes Document, Chapter, Paragraph, Character). They should implement the Composite design pattern. Each one should have methods 'print' and 'add...' ('addChapter' in the Document class, 'addParagraph' in the ChapterClass, etc.).

Classes Character and Paragraph should also implement the Flyweight design pattern: similar objects will be represented by only 1 object instance. The Inner state of the Character class (stored as a field in this class) will be simply an ASCII code (or 'char' variable). The Outer state of the Character class (stored outside this class - e.g. in the Paragraph) will be the boolean variable "big letter/small letter" . So all 'a' and 'A' characters in the entire document will be represented by only 1 Character('a') object, the paragraph objects will contain many references to this object. The outer state (boolean) shall be passed as a parameter to the 'print' method.

The Character objects should be managed by a Character pool/factory class and must not be created by the end-user (like in the Singleton pattern, private constructor, etc).This functionality can be implemented as static components of the Character class, for instance:
public static Character getCharacter(char c);
and
private static HashMap<char, Character> characters; (Java 1.5)

The Outer state should be stored outside the Character class - in the Paragraph class - in a compressed form. A RLE compression can be used: it compresses a sequence as quantities of the identical neighbour objects, here: quantity of big letter | quantity of small letter | quantity of big letters | ... For instance a phrase 'ABcdefGhijk' can be stored as a chain of Character objects ('a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k') and 2-4-1-4 sequence (2 big letters, 4 small letters, 1 big letter, 4 small letters).

The 'print' method, because of the Composite pattern requirement, should have the same interface in all the classes. In the Character class it needs 1 boolean parameter (big/small), so all these methods must take 1 object parameter: in the class Character it will be casted to the Boolean class and then to the bool primitive variable, in the other classes it will ignored:
```
void print(Object param);
```
in Character:
```
{
bool big = ((Boolean)(param)).booleanValue();
...
}
```


In the function main, create 1 simple document and print it:
```
Document d=new Document();
Chapter c=new Chapter();
Paragraph p = new Paragraph("A simple paragraph. Build from 2 sentences."); //inside this constructor it must be converted to the collection of references to 'Character' objects and the RLE sequence.
c.addParagraph(p);
d.addChapter(c);

d.print(null);
c.print(null);
```