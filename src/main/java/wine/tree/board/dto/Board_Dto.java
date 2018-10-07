package wine.tree.board.dto;

import java.io.Serializable;

public class Board_Dto implements Serializable {
	
	private static final long serialVersionUID = 1833026521294729077L;
	
	private int seq;
	private String id;
	private String writer;
	private String title;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private int readCount;
	private String regdate;
	private String delflag;
	
	public Board_Dto() {
		super();
	}
	
	public Board_Dto(int seq, String id, String writer, String title, String content, int ref, int step, int depth, int readCount, String regdate, String delflag) {
		this.seq = seq;
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.readCount = readCount;
		this.regdate = regdate;
		this.delflag = delflag;
	}
	
	@Override
	public String toString() {
		return "Board_Dto{" +
			"seq=" + seq +
			", id='" + id + '\'' +
			", writer='" + writer + '\'' +
			", title='" + title + '\'' +
			", content='" + content + '\'' +
			", ref=" + ref +
			", step=" + step +
			", depth=" + depth +
			", readCount=" + readCount +
			", regdate='" + regdate + '\'' +
			", delflag='" + delflag + '\'' +
			'}';
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getRef() {
		return ref;
	}
	
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getReadCount() {
		return readCount;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getDelflag() {
		return delflag;
	}
	
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
}
