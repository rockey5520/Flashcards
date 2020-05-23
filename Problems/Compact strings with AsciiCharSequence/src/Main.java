class AsciiCharSequence implements java.lang.CharSequence {
  // implementation
  private byte[] array;

  public AsciiCharSequence(byte[] array) {
    this.array = array.clone();
  }

  @Override
  public int length() {
    return array.length;
  }

  @Override
  public char charAt(int index) {
    return (char) array[index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return new AsciiCharSequence(java.util.Arrays.copyOfRange(array, start, end));
  }

  @Override
  public String toString() {
    return new String(array);
  }
}