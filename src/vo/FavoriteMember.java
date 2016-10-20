package src.portfolio.VO;

public class FavoriteMember {
	String id;
	String acceptor;
	boolean favoriteCheck;
	String requestTimeStamp;
	String acknowledgeTimeStamp;
	
	public FavoriteMember() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "FavoriteMember [id=" + id + ", acceptor=" + acceptor + ", favoriteCheck=" + favoriteCheck
				+ ", requestTimeStamp=" + requestTimeStamp + ", acknowledgeTimeStamp=" + acknowledgeTimeStamp + "]";
	}
	
	
	
}
