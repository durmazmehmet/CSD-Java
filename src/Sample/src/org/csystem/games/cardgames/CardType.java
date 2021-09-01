package org.csystem.games.cardgames;

public enum CardType
{
	SPADE("Maça"), CLUB("Sinek"), DIAMOND("Karo"), HEART("Kupa");
	private final String m_str;
	CardType(String str)
	{
		m_str = str;
	}

	public String getStr()
	{
		return m_str;
	}

	public static CardType getCardTypeByString(String str)
	{
		CardType result = null;

		for (CardType cardType : CardType.values())
			if (cardType.m_str.equals(str)) {
				result = cardType;
				break;
			}

		return result;
	}
}

