# Prelimenär projektplan

## Vad ni ska göra

Vi ska göra ett program som ska autonomn redigera bilder med diverse filter, exempelvis att pixelera en bilder för att göra *pixelart*.

## Hur ni tänker att ni ska göra det (detta kommer säkert ändras under projeketets gång, men berätta vad planen är just nu)

Vi planerar att skriva ett program i C#. Vi ämnar att nyttja ett library för C# för att läsa in och hantera bilderna men själva utveckla algoritmerna för att behandla bilderna.

Själva programmet kommer kunna delas upp i flera moduler, bland annat varje filter, den interna renderingen, in- och utläsning av bilder osv.

## Vad er MVP är och vilken funktionalitet ni vill lägga till om ni har tid

Vår `minimal viable product` är att programmet ska kunna skapa pixelart av godtyckliga bilder i `.jpeg`- och `.png`-format. I mån av tid vill vi lägga till fler *filter* och möjligheter till att justera filtrerna.

## Om det finns några potentiella problem eller hinder som ni förutser

Det kan eventuellt bli problem att behandla olika stora bilder, i synnerhet om de är väldigt stora.