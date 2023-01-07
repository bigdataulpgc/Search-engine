# Search-engine

This project deals with the implementation of a search engine. 

You can learn about the project in depth at [LINK TO PAPER](https://github.com/bigdataulpgc/Search-engine/blob/main/Crawler_Paper.pdf).

The objectives to be achieved are:

- Inverted index
- Crawler development
- Query engine development
- Set Up Google Cloud Platform
- Development of indexer module
- Evolve the reverse index to use hazelcast
- Final integration

## PROJECT STATUS:

At the moment we have realized the crawler module, inverted index and query engine.

## DEVELOPERS:

- Álvaro Juan Travieso García
- Alba Martín Lorenzo
- Victoria Torres Rodríguez
- Joel Del Rosario Pérez
- Jorge Langlenton Ferreiro

## INSTRUCTIONS FOR USE:

You must take into account that the device on which you are going to run the program must not be associated with OneDrive, as it could give errors when creating the files referring to the inverted indexes due to conflicts in their naming.

### Inverted index

The program requires three directories: 
- The first one with files whose extension has to be json, each one refers to the metadata of a book.
- The second one with files whose extension has to be txt, and each one contains the content of a book.
- The third contains a set of folders with letter names (one for each letter of the alphabet), inside each folder there is a set of tsv files with names of words found in the books whose initial letter matches the folder name (e.g. book.tsv in folder "b"). In each tsv we find the documents in which the word appears followed by a list indicating the lines in which the words appear in that document.

* NOTE: For each document in json there must be a txt, both with the same name, which will be the identifier of each book (for example book1.json and book1.txt).

### Crawler

The software downloads one book per minute from a given website.
The organization of the Document Repository is chronological with a folder for each date using the yyyymmdd format and within each folder, a json document with the metadata, a txt document with the content and a txt document with additional information (original source id, original source domain, etc) for each document downloaded on that date.

## TECHNOLOGY USED:

### Programing languaje

- Java 11

### Libraries

- junit 4.13.2
- assertj 3.23.1
- jsoup 1.15.3
- gson 2.8.6