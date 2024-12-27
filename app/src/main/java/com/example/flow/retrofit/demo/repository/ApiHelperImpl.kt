package com.example.flow.retrofit.demo.repository

import com.example.flow.retrofit.demo.model.ApiUser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    private val gson = Gson()
    override fun getUsers(page:Int) = flow {
        //emit(apiService.getUsers())
        emit(getUser(page = page))
    }

    override fun getUsersWithError() = flow {
        emit(apiService.getUsersWithError())
    }

    private fun getUser(page: Int):List<ApiUser> {
        val json = when(page){
            1-> {
                """
                    [
                    {
    "id": 1,
    "name": "Roman",
    "email": "rpenburton0@yellowbook.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 2,
    "name": "Tracey",
    "email": "tvidgeon1@nifty.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 3,
    "name": "Nickolaus",
    "email": "nkuban2@delicious.com",
    "avatar": "https://dummyimage.com/100x100.png/cc0000/ffffff"
  },
  {
    "id": 4,
    "name": "Dyanna",
    "email": "dreggler3@vinaora.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 5,
    "name": "Pearla",
    "email": "pveregan4@chronoengine.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 6,
    "name": "Edlin",
    "email": "eeble5@yelp.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 7,
    "name": "Lisetta",
    "email": "lrushbrook6@jimdo.com",
    "avatar": "https://dummyimage.com/100x100.png/dddddd/000000"
  },
  {
    "id": 8,
    "name": "Fairfax",
    "email": "fhardypiggin7@state.gov",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 9,
    "name": "Julissa",
    "email": "jbeadel8@examiner.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 10,
    "name": "Alfy",
    "email": "aderkes9@booking.com",
    "avatar": "https://dummyimage.com/100x100.png/dddddd/000000"
  },
  {
    "id": 11,
    "name": "Kip",
    "email": "kpethricka@webmd.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 12,
    "name": "Lyn",
    "email": "lreillyb@house.gov",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 13,
    "name": "Reidar",
    "email": "remmattc@dagondesign.com",
    "avatar": "https://dummyimage.com/100x100.png/dddddd/000000"
  },
  {
    "id": 14,
    "name": "Biddie",
    "email": "bpawlickd@va.gov",
    "avatar": "https://dummyimage.com/100x100.png/dddddd/000000"
  },
  {
    "id": 15,
    "name": "Burt",
    "email": "bbedrosiane@bloomberg.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 16,
    "name": "Winne",
    "email": "wgroutf@geocities.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 17,
    "name": "Ava",
    "email": "abassomg@cloudflare.com",
    "avatar": "https://dummyimage.com/100x100.png/5fa2dd/ffffff"
  },
  {
    "id": 18,
    "name": "Waldon",
    "email": "wkaliszewskih@google.com.au",
    "avatar": "https://dummyimage.com/100x100.png/dddddd/000000"
  },
  {
    "id": 19,
    "name": "Arlinda",
    "email": "alehucqueti@wired.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  },
  {
    "id": 20,
    "name": "Lexine",
    "email": "lscoreyj@artisteer.com",
    "avatar": "https://dummyimage.com/100x100.png/ff4444/ffffff"
  }
                    ]
                    
                """.trimIndent()
            }
            2->{
                """
                    [
                    {
    "name": "Jaime Williamson",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1195.jpg",
    "email": "Abigail.Graham63@yahoo.com",
    "id": "21"
  },
  {
    "name": "Sherri Gislason",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/185.jpg",
    "email": "Taya_Jacobs@gmail.com",
    "id": "22"
  },
  {
    "name": "Luther Weimann",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1120.jpg",
    "email": "Ron_Hudson43@yahoo.com",
    "id": "23"
  },
  {
    "name": "Bryan Jaskolski",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/60.jpg",
    "email": "Darrin66@hotmail.com",
    "id": "24"
  },
  {
    "name": "Jerome Christiansen",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/847.jpg",
    "email": "Ewald_Abshire@yahoo.com",
    "id": "25"
  },
  {
    "name": "Jacqueline Goodwin",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/466.jpg",
    "email": "Lionel_Waters48@yahoo.com",
    "id": "26"
  },
  {
    "name": "Ana McDermott",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/792.jpg",
    "email": "Karlie_Kub90@gmail.com",
    "id": "27"
  },
  {
    "name": "Roxanne Kreiger",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/682.jpg",
    "email": "Earlene.Heaney@yahoo.com",
    "id": "28"
  },
  {
    "name": "Nicole Quigley",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/116.jpg",
    "email": "Rene_Bartoletti@yahoo.com",
    "id": "29"
  },
  {
    "name": "Shelia D'Amore",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/50.jpg",
    "email": "Briana46@yahoo.com",
    "id": "30",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Cindy Franey",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/908.jpg",
    "email": "Ova_Walsh71@yahoo.com",
    "id": "31",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Ed Kessler",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/8.jpg",
    "email": "Abbigail81@gmail.com",
    "id": "32",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Tanya Effertz",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/154.jpg",
    "email": "Adolfo_Lehner30@gmail.com",
    "id": "33",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Nick O'Reilly",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/362.jpg",
    "email": "Hardy_Miller28@yahoo.com",
    "id": "34",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Becky O'Hara",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/715.jpg",
    "email": "Macy.Hansen@hotmail.com",
    "id": "35",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Mrs. Amy Friesen",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1138.jpg",
    "email": "Kathryne2@hotmail.com",
    "id": "36",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Irvin Goldner",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/696.jpg",
    "email": "Jacynthe.Bartoletti58@yahoo.com",
    "id": "37",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Elizabeth Shanahan",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/158.jpg",
    "email": "Verla74@gmail.com",
    "id": "38",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Orlando Lesch IV",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/107.jpg",
    "email": "Thea_Witting@hotmail.com",
    "id": "39",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Sean Keeling",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/251.jpg",
    "email": "Berry.Feil40@yahoo.com",
    "id": "40",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  }
                    ]  
                """.trimIndent()
            }
            3->{
                """
                    [
                    {
    "name": "Boyd Ebert",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/345.jpg",
    "email": "Pedro_Walker@gmail.com",
    "id": "41",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Lena Gerhold I",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/756.jpg",
    "email": "Casandra46@yahoo.com",
    "id": "42",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Tommy Douglas DDS",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1167.jpg",
    "email": "Maegan_Schmitt@hotmail.com",
    "id": "43",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Ms. Christy Treutel",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/202.jpg",
    "email": "Bonnie_Welch59@yahoo.com",
    "id": "44",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Mattie Bins",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/847.jpg",
    "email": "Martin_OKeefe@hotmail.com",
    "id": "45",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Justin Kohler",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/88.jpg",
    "email": "Zelda_Fadel@hotmail.com",
    "id": "46",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Richard Lowe",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1085.jpg",
    "email": "Gerald_Nitzsche46@yahoo.com",
    "id": "47",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Rolando Wuckert",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/611.jpg",
    "email": "Linnie76@hotmail.com",
    "id": "48",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Neal Ondricka",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/152.jpg",
    "email": "Rocio_Will80@hotmail.com",
    "id": "49",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Clint Lang",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/893.jpg",
    "email": "Maximo.Kiehn51@hotmail.com",
    "id": "50",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Ervin Sauer",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/173.jpg",
    "email": "Madisen80@hotmail.com",
    "id": "51",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Lance Wolf Jr.",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/520.jpg",
    "email": "Aidan_Stamm91@gmail.com",
    "id": "52",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Genevieve Wiegand IV",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/737.jpg",
    "email": "Kenyatta49@yahoo.com",
    "id": "53",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Claudia Bins",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/33.jpg",
    "email": "Richie64@hotmail.com",
    "id": "54",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Jordan Ortiz",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/379.jpg",
    "email": "Rupert.Murray@hotmail.com",
    "id": "55",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Della Kreiger",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/891.jpg",
    "email": "Miles_Carter25@yahoo.com",
    "id": "56",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Christy Gutmann",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/408.jpg",
    "email": "Emilio8@hotmail.com",
    "id": "57",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Dustin Hand",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/99.jpg",
    "email": "Meaghan22@hotmail.com",
    "id": "58",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Marilyn Dibbert",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/683.jpg",
    "email": "Adonis14@yahoo.com",
    "id": "59",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Peggy Waelchi",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/507.jpg",
    "email": "Johathan43@gmail.com",
    "id": "60",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  }
                    ]  
                """.trimIndent()
            }
            4->{
                """
                    [
                    {
    "name": "Horace Pfannerstill",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1011.jpg",
    "email": "Brayan_McCullough65@gmail.com",
    "id": "61",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Alice Gulgowski",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/836.jpg",
    "email": "Devonte43@hotmail.com",
    "id": "62",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Alexandra Marks",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/832.jpg",
    "email": "Morgan16@gmail.com",
    "id": "63",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Raymond Klocko",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/476.jpg",
    "email": "Javier_Goldner@hotmail.com",
    "id": "64",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Jody Graham",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/602.jpg",
    "email": "Abelardo.Will@yahoo.com",
    "id": "65",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Clifton Fadel",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/596.jpg",
    "email": "Deontae.Schumm@gmail.com",
    "id": "66",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Dr. Sarah Jakubowski",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1019.jpg",
    "email": "Rickie_Hansen@hotmail.com",
    "id": "67",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Kimberly Morar Sr.",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/924.jpg",
    "email": "Agustina96@gmail.com",
    "id": "68",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Melba Wolff DDS",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/119.jpg",
    "email": "Summer.Hessel30@gmail.com",
    "id": "69",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Dr. Marta Walker",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1150.jpg",
    "email": "Letitia.Purdy0@yahoo.com",
    "id": "70",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Stewart Kassulke",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/467.jpg",
    "email": "Bulah40@hotmail.com",
    "id": "71",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Harold Zboncak",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/324.jpg",
    "email": "Trisha_Brown69@gmail.com",
    "id": "72",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Jessie Wilderman",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1081.jpg",
    "email": "Ezra.Koepp@gmail.com",
    "id": "73",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Wendell Zulauf DDS",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1146.jpg",
    "email": "Winona.Upton@gmail.com",
    "id": "74",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Rodney Bednar",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/766.jpg",
    "email": "Kaylee_Franecki1@gmail.com",
    "id": "75",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Emma Konopelski PhD",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/52.jpg",
    "email": "Kaden_Ebert@yahoo.com",
    "id": "76",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Ms. Rose Schuster",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/383.jpg",
    "email": "Kareem_Leuschke@yahoo.com",
    "id": "77",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Gina Ledner",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/287.jpg",
    "email": "Hilbert_Dickens11@gmail.com",
    "id": "78",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Violet Turner",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/101.jpg",
    "email": "Angelica.Schuster@yahoo.com",
    "id": "79",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  },
  {
    "name": "Shane Yundt V",
    "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1114.jpg",
    "email": "Garrick.King73@yahoo.com",
    "id": "80",
    "userId": "22873363",
    "userToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA",
    "device_Token": "d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ"
  }
                    ]  
                """.trimIndent()
            }
            else->{"[]"}
        }


        val listType = object : TypeToken<List<ApiUser>>() {}.type
        val userList: List<ApiUser> = gson.fromJson(json, listType)
        return userList
    }

}
