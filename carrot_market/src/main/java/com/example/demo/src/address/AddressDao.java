package com.example.demo.src.address;


import com.example.demo.src.address.model.*;
import com.example.demo.src.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> hoy_branch
import java.util.List;

@Repository
public class AddressDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<GetTownRes> getTownOrderByAddress(String search,Double lat,Double lng){
        String getTownOrderByAddressQuery = "select city,\n" +
                "       district,\n" +
                "       townName,\n" +
                "       case\n" +
                "           when T.townId in (select townId from TownEtc where etc is not null)\n" +
                "               then group_concat(etc separator ', ')\n" +
                "           else NULL\n" +
                "           end as etc\n" +
                "\n" +
                "from Town as T\n" +
                "         left outer join TownEtc TE on T.townId = TE.townId\n" +
                "where city like concat('%', ?, '%')\n" +
                "   or district like concat('%', ?, '%')\n" +
                "   or townName like concat('%', ?, '%')\n" +
                "   or T.townId in (select townId from TownEtc where etc like concat('%', ?, '%'))\n" +
                "group by city, district, townName, lat, lng\n" +
                "order by (6371 * acos(cos(radians(?)) * cos(radians(lat)) * cos(radians(lng) - radians(?)) +\n" +
                "                      sin(radians(?)) * sin(radians(lat))))";
        return this.jdbcTemplate.query(getTownOrderByAddressQuery,
                (rs, rowNum) -> new GetTownRes(
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("townName"),
                        rs.getString("etc")
                ),

                search,search,search,search,lat,lng,lat);
    }

    public List<GetTownRes> getTownOrderByName(String search){
        String getTownOrderByNameQuery = "select city,\n" +
                "       district,\n" +
                "       townName,\n" +
                "       case\n" +
                "           when T.townId in (select townId from TownEtc where etc is not null)\n" +
                "               then group_concat(etc separator ', ')\n" +
                "           else NULL\n" +
                "           end as etc\n" +
                "\n" +
                "from Town as T\n" +
                "         left outer join TownEtc TE on T.townId = TE.townId\n" +
                "where city like concat('%', ?, '%')\n" +
                "   or district like concat('%', ?, '%')\n" +
                "   or townName like concat('%', ?, '%')\n" +
                "   or T.townId in (select townId from TownEtc where etc like concat('%', ?, '%'))\n" +
                "group by city, district, townName\n" +
                "order by city, district, townName";
        return this.jdbcTemplate.query(getTownOrderByNameQuery,
                (rs, rowNum) -> new GetTownRes(
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("townName"),
                        rs.getString("etc")
                ),

                search,search,search,search);
    }

<<<<<<< HEAD
    public GetLocation getLocation(int townId){
        String getLocationQuery = "select lat, lng from Town where townId = ? ";
        return this.jdbcTemplate.queryForObject(getLocationQuery,
=======

    public int getTownIdByUserId(int userId) {
        String getTownIdQuery = "select townId from Address where userId = ? and selectAddress = 'Valid'";
        return this.jdbcTemplate.queryForObject(getTownIdQuery,
                int.class,
                userId);
    }

    public GetLocation getLocation(int townId){
        String getLocationIdQuery = "select lat, lng from Town where townId = ? ";
        return this.jdbcTemplate.queryForObject(getLocationIdQuery,
>>>>>>> hoy_branch
                (rs, rowNum) -> new GetLocation(
                        rs.getDouble("lat"),
                        rs.getDouble("lng")
                ),
                townId);
    }

<<<<<<< HEAD
=======
    public String isCertifiedAddress(int userId, int townId){
        String getIsCertifiedAddressQuery = "select certification from Address where userId = ? and townId = ?";
        return this.jdbcTemplate.queryForObject(getIsCertifiedAddressQuery,
                String.class,
                userId, townId);
    }


    public int getTownExist(GetTownReq getTownReq){
        String getTownExistQuery = "select exists(select townId from Town where city = ? and district = ? and townName = ?)";
        return this.jdbcTemplate.queryForObject(getTownExistQuery,
                int.class,
                getTownReq.getCity(), getTownReq.getDistrict(), getTownReq.getTownName());
    }

    public int getTownIdByGetTownReq(GetTownReq getTownReq){
        String getTownIdQuery = "select townId from Town where city = ? and district = ? and townName = ?";
        return this.jdbcTemplate.queryForObject(getTownIdQuery,
                int.class,
                getTownReq.getCity(), getTownReq.getDistrict(), getTownReq.getTownName());
    }


>>>>>>> hoy_branch
    public List<GetTownRes> getNearTownOrderByName(Double lat, Double lng){
        String getNearTownOrderByName = "select T.townId,city,\n" +
                "       district,\n" +
                "       townName,\n" +
                "       case\n" +
                "           when T.townId in (select townId from TownEtc where etc is not null)\n" +
                "               then group_concat(etc separator ', ')\n" +
                "           else NULL\n" +
                "           end as etc\n" +
                "\n" +
                "from Town as T\n" +
                "         left outer join TownEtc TE on T.townId = TE.townId\n" +
                "\n" +
                "group by city, district, townName, lat, lng\n" +
                "order by (6371 * acos(cos(radians(?)) * cos(radians(lat)) * cos(radians(lng) - radians(?)) +\n" +
                "                      sin(radians(?)) * sin(radians(lat))))";

        return this.jdbcTemplate.query(getNearTownOrderByName,
                (rs, rowNum) -> new GetTownRes(
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("townName"),
                        rs.getString("etc")
                ),
                lat,lng,lat);
    }

<<<<<<< HEAD
    public int getTownId(String city,String district,String townName){
        String gettownIdQuery = "select townId from Town where city = ? and district = ? and townName = ? ";
        return this.jdbcTemplate.queryForObject(gettownIdQuery,
                int.class,
                city, district, townName
        );
    }


    public ArrayList<Integer> getNearTownListByRange(int range, Double lat, Double lng){
        String getNearTownIdQuery = "SELECT townId\n" +
                "FROM Town\n" +
                "where ((6371 * acos(cos(radians(?)) * cos(radians(lat)) *\n" +
                "                   cos(radians(lng) - radians(?)) +\n" +
                "                   sin(radians(?)) * sin(radians(lat)))) < ?)";

        ArrayList<Integer> list = new ArrayList<>();

        this.jdbcTemplate.query(getNearTownIdQuery,
                (rs, rowNum) -> list.add(rs.getInt("townId")),
                lat,lng,lat, range);
        return list;

    }
=======

>>>>>>> hoy_branch
}
