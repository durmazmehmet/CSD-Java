package org.csystem.games.cardgames;

public enum CardValue
{
	TWO("İki"), THREE("Üç"), FOUR("Dört"), FIVE("Beş"), SIX("Altı"), SEVEN("Yedi"),
    EIGHT("Sekiz"), NINE("Dokuz"), TEN("On"), KNAVE("Vale"), QUEEN("Kız"), KING("Papaz"), ACE("As");
    private final String m_str;

	CardValue(String str)
    {
        m_str = str;
    }

    public String getStr()
    {
        return m_str;
    }

    public static CardValue getCardValueByString(String str)
    {
        CardValue result = null;

        for (CardValue cardValue : CardValue.values())
            if (cardValue.m_str.equals(str)) {
                result = cardValue;
                break;
            }

        return result;
    }
}
