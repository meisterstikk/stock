package demopubsub;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Stock_table")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String mouseName;
    private Integer qty;

    @PostUpdate
    public void onPostUpdate(){
        StockChanged stockChanged = new StockChanged();
        BeanUtils.copyProperties(this, stockChanged);
        stockChanged.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
