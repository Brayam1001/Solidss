package Servicios;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import java.util.*;

public class FuncionarioServicio {

    private FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioServicio(FuncionarioRepositorio funcionariorepositorios) {
        this.funcionarioRepositorio = funcionariorepositorios;
    }

    public boolean createFUncionario(Funcionario funcionario) {
        return funcionarioRepositorio.create(funcionario);

    }

    public Funcionario getFuncionario(int id) {
        return funcionarioRepositorio.read(id);
    }
    public List<Funcionario> getAllFuncionario(){
        return funcionarioRepositorio.readAll();
        
    }
    public boolean updateFuncionario(Funcionario funcionario){
        return funcionarioRepositorio.update(funcionario);
    }
    public boolean deleteFuncionario (int id){
        return funcionarioRepositorio.delete(id);
    }
}
