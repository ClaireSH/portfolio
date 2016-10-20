package vo;

public class FavoriteMember {
	String memberId;
	String acceptor;
	boolean favoriteCheck;
	String requestTimeStamp;
	String acknowledgeTimeStamp;
	
	public FavoriteMember() {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public boolean isFavoriteCheck() {
		return favoriteCheck;
	}

	public void setFavoriteCheck(boolean favoriteCheck) {
		this.favoriteCheck = favoriteCheck;
	}

	public String getRequestTimeStamp() {
		return requestTimeStamp;
	}

	public void setRequestTimeStamp(String requestTimeStamp) {
		this.requestTimeStamp = requestTimeStamp;
	}

	public String getAcknowledgeTimeStamp() {
		return acknowledgeTimeStamp;
	}

	public void setAcknowledgeTimeStamp(String acknowledgeTimeStamp) {
		this.acknowledgeTimeStamp = acknowledgeTimeStamp;
	}

	@Override
	public String toString() {
		return "FavoriteMember [memberId=" + memberId + ", acceptor=" + acceptor + ", favoriteCheck=" + favoriteCheck
				+ ", requestTimeStamp=" + requestTimeStamp + ", acknowledgeTimeStamp=" + acknowledgeTimeStamp + "]";
	}
	
	
	
	
}
