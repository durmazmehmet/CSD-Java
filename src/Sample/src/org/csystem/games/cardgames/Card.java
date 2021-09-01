package org.csystem.games.cardgames;

import java.util.Random;

public class Card {
   private static final int COUNT = 200;
   private CardValue m_value;
   private CardType m_type;

   private static void swap(Card [] card, int i, int k)
   {
      Card temp;

      temp = card[i];
      card[i] = card[k];
      card[k] = temp;
   }

   private static Card[] shuffle(Card [] deck, int n)
   {
      Random r = new Random();

      for (int i = 0; i < n; ++i)
         swap(deck, r.nextInt(52), r.nextInt(52));

      return deck;
   }

   private static void doWorkDorException(String message)
   {
      System.out.println(message);
      System.exit(-1); //exception işlemlerine kadar sabredin
   }

   private static Card[] getNewDeck()
   {
      Card[] deck = new Card[52];

      int index = 0;

      for (CardType cardType : CardType.values())
         for (CardValue cardValue : CardValue.values())
            deck[index++] = new Card(cardType, cardValue);

      return deck;
   }

   private void setCard(String [] cardInfo)
   {
      CardType cardType = CardType.getCardTypeByString(cardInfo[0]);
      CardValue cardValue = CardValue.getCardValueByString(cardInfo[1]);

      if (cardType == null || cardValue == null)
         doWorkDorException("Invalid card name");

      m_type = cardType;
      m_value = cardValue;
   }

   public static Card[] getShuffledDeck()
   {
      return shuffle(getNewDeck(), COUNT);
   }

   public static void shuffle(Card [] deck)
   {
      shuffle(deck, COUNT);
   }

   public Card(String name)
   {
      this.setName(name);
   }

   public Card(CardType type, CardValue value)
   {
      this.setType(type);
      this.setValue(value);
   }

   public String getName()
   {
      return String.format("%s-%s", m_type.getStr(), m_value.getStr());
   }

   public void setName(String name)
   {
      String [] cardInfo = name.split("[-]");

      if (cardInfo.length != 2)
         doWorkDorException("Invalid card name format");

      this.setCard(cardInfo);
   }

   public CardType getType()
   {
      return m_type;
   }

   public void setType(CardType type)
   {
      if (type == null)
         doWorkDorException("null value not accepted");

      m_type = type;
   }

   public CardValue getValue()
   {
      return m_value;
   }

   public void setValue(CardValue value)
   {
      if (value == null)
         doWorkDorException("null value not accepted");

      m_value = value;
   }

   public String toString()
   {
      return this.getName();
   }
}
