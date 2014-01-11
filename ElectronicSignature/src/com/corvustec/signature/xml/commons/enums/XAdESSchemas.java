package com.corvustec.signature.xml.commons.enums;

public enum XAdESSchemas
implements Comparable<XAdESSchemas>
{
XAdES_111("1.1.1", "http://uri.etsi.org/01903/v1.1.1#"),
XAdES_122("1.2.2", "http://uri.etsi.org/01903/v1.2.2#"),
XAdES_132("1.3.2", "http://uri.etsi.org/01903/v1.3.2#");

private String name;
private String uri;

private XAdESSchemas(String name, String uri) { this.name = name;
  this.uri = uri; }

public String getSchemaVersion()
{
  return this.name;
}

public String toString()
{
  return this.name;
}

public String getSchemaUri() {
  return this.uri;
}

public static XAdESSchemas getXAdESSchema(String esquemaUri) {
  XAdESSchemas resultado = null;
  if (esquemaUri != null) {
    if (XAdES_111.uri.equals(esquemaUri))
      resultado = XAdES_111;
    else if (XAdES_122.uri.equals(esquemaUri))
      resultado = XAdES_122;
    else if (XAdES_132.uri.equals(esquemaUri)) {
      resultado = XAdES_132;
    }
  }
  return resultado;
}
}