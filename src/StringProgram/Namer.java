package StringProgram;

/**
 * @author : apitale
 * @Date : 12/14/20
 */
public class Namer {

  final String fn, ln;

  public Namer(String fn, String ln) {
    this.fn = fn;
    this.ln = ln;
  }

  public String getFn() {
    return fn;
  }

  public String getLn() {
    return ln;
  }
}
