package br.com.videoaulazeni.exemploWS;

public class Usuario {
    private int id;
    private String nomeProprietario;
    private String nomeFazenda;
    private String plantio;
    private String endereco;
    private String telContato;
    private int area;

    
	public Usuario() {
    }
    public Usuario(int id, String nomeProprietario, String nomeFazenda, String plantio, String endereco,String telContato, int area ) {
        this.id = id;
        this.nomeProprietario = nomeProprietario;
        this.telContato = telContato;
        this.nomeFazenda = nomeFazenda;
        this.plantio = plantio;
        this.endereco = endereco;
        this.area = area;
    }
    public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getNomeFazenda() {
        return nomeFazenda;
    }

    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    public String getPlantio() {
        return plantio;
    }

    public void setPlantio(String plantio) {
        this.plantio = plantio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
