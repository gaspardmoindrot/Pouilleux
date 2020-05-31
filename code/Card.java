package code;

public class Card
{
	private int	mRank;
	private String	mSuit;

	public Card(int rank, int suit) {
		this.mRank = rank;
		if (suit == 1)
			this.mSuit = "clover";
		else if (suit == 2)
			this.mSuit = "heart";
		else if (suit == 3)
			this.mSuit = "spade";
		else if (suit == 4)
			this.mSuit = "diamond";
	}

	public int get_rank() { return (this.mRank); }
	public String get_suit() { return (this.mSuit); }
	public void print() { System.out.println(this.mRank + " of " + this.mSuit); }
}
