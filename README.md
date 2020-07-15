# Progetto_PO_Luglio_2020
L'applicazione consente di fare l'analisi dei tweets dell'utente VirusesMDPI, analizzandone il testo e i contenuti multimediali, facendone poi delle statistiche e permettendone il filtraggio. 
## Funzionamento
All'avvio l'applicazione scarica i tweets in formato JSON e ne effettua il parsing inserendo, per ogni tweet, tutti i dati necessari in un modello appositamente costruito.
Una volta creati e inseriti i modelli all'interno di una lista il programma attende istruzioni dall'utente. Esso può richiedere i dati, i metadati, filtrare o ottenere statistiche sui dati ottenuti.
![](SequenceDiagram.jpg)
## Statistiche
Si ha la possibilità di ricevere statistiche su:

1) Numero di tweet per giorno, mese, anno
2) Lunghezza delle parole presenti nel testo
3) Numero di url presenti
4) Numero di hashtags presenti in un post
5) Larghezza, altezza e dimensioni delle immagini

Per ottenere tali statistiche è necessario inserire un parametro denominato "Stat" e assegnargli i seguenti valori:

1) date
2) text
3) url
4) hashtags
5) image

È inoltre possibile richiedere anche la lista delle parole e degli hastags utilizzati, con le relative occorrenze. Il numero N delle parole presenti nella lista è impostabile dall'utente.

Tutte queste statistiche possono essere calcolate a partire da tutto l'insieme dei dati ottenuti, oppure su un insieme più piccolo derivato da un operazione di filtraggio dei dati.
## Filtri
I filtri sono una stringa in formato JSON strutturata nel modo seguente:
```
{"campo" : {"operatore" : "valore"}}
```
Campo:
- **date**: specifica un filtro rispetto la data presente nei tweets
- **text**: specifica un filtro rispetto alla lunghezza (per singolo carattere) del testo nei tweets
- **w**: specifica un filtro rispetto alla larghezza delle immagini prenti nei tweets
- **h**: specifica un filtro rispetto all'altezza delle immagini presenti nei tweets
- **dimension**: specifica un filtro rispetto alla dimensione delle immagini presenti nei tweets

Operatore:
- **$not**: indica se il valore associato al campo è diverso da quello indicato nel filtro
- **$in**: indica se il valore associato al campo è uguale a uno dei valori inseriti nel filtro
- **$nin**: indica se il valore associato al campo è diverso da tutti i valori inseriti nel filtro
- **$gt**: indica se il valore associato al campo è maggiore di quello indicato nel filtro
- **$gte**: indica se il valore associato al campo è maggiore o uguale di quello indicato nel filtro
- **$lt**: indica se il valore associato al campo è minore di quello inserito nel filtro
- **$lte**: indica se il valore associato al campo è minore o uguale di quello inserito nel filtro
- **$bt**: indica se il valore associato al campo è compreso tra i due valori inseriti nel filtro (esclusi)

È importante sottolineare che:
1) L'applicazione accetta solo valori di tipo stringa. Quando si scrive un numero è dunque necessario scrivere "numero".
2) Quando si inserisce una data è necessario scriverla nel seguente formato: "gg/mm/aaaa".

Nel caso in cui non si verifichi ciò che scritto sopra l'applicazione restituirà degli errori personalizzati. 

Il programma fornisce anche la possibilità di utilizzare più filtri inisieme attraverso l'uso di operatori logici quali: "$and", "$or". La strutura è la seguente:
```
{"operatore logico" : [{"filtro"}{"filtro"}..]}
```
Alcuni esempi di filtri sono:
```
{
    "$or": [
        {
            "date": {
                "$in": [
                    "13/07/2020",
                    "14/07/2020"
                ]
            }
        },
        {
            "w": {
                "$lt": "800"
            }
        }
    ]
}

{
    "$and": [
        {
            "date": {
                "$in": [
                    "13/07/2020",
                    "14/07/2020"
                ]
            }
        },
        {
            "w": {
                "$lt": "800"
            }
        }
    ]
}

{
    "text": {
        "$lt": "100"
    }
}

{
    "date": {
        "$bt": [
            "10/07/2020",
            "14/07/2020"
        ]
    }
}

{
    "dimension": {
        "$bt": [
            "200000",
            "220000"
        ]
    }
}

{
    "dimension": {
        "$lte": "210650"
    }
}
```
## Rotte
Per eseguire le operazioni di cui sopra l'applicazione prevede diverse rotte:
> **GET**/metadata

Fornisce tutti i metadati
> **GET**/data

Fornisce tutti i dati ottenuti
> **GET**/statistics

Fornisce le statistiche relative al parametro specificato: Stat=statistica richiesta
> **GET**/wordlist

Fornisce la lista delle parole più utilizzate con le relative occorrenze. Si può specificare un parametro denominato N per richiedere la top N delle parole.
> **GET**/hashlist
  
Fornisce la lista degli hashtags con le relative occorrenze
> **POST**/filter

Fornisce i dati filtrati con il filtro posto nel corpo della richiesta
> **POST**/filteredstats

Fornisce le statistiche ottenute da un campione di dati filtrati. Si può sia inserire un filtro nel corpo della richiesta, sia inserire un parametro denominato "Stat" che specifichi la statistica richiesta




