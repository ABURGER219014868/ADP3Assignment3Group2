package za.ac.cput.repository;

public interface IRepository<C,cd> {
public String cd = null;

    public C Create(C c);

    public C Read(cd CD);

    public C Update(C c);

    public boolean Delete(cd CD);
}
