package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alanmr.kemeapp.R


@Composable
fun AccountCard(
    account: String,
    onTap: ()-> Unit,
    onLogout: ()-> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.primary)
    ) {
        Column(modifier = Modifier
            .weight(2f)
            .padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.account), color = MaterialTheme.colors.onPrimary, modifier = Modifier.weight(2f))
                Column(
                    verticalArrangement= Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {
                            onLogout()
                        }) {
                    Image(painter = painterResource(id = R.drawable.logout),
                        contentDescription = stringResource(id = R.string.logout),
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                        modifier = Modifier.width(48.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = account,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.caption,
                maxLines = 1
            )
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.gold),
                    contentDescription = stringResource(id = R.string.point),
                    modifier = Modifier
                        .padding(10.dp)
                        .height(60.dp)
                    )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row {
                        Text(text = "1290", color = Color.White, style = MaterialTheme.typography.h5)
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "Point", color = Color(0xFFF1B32B), style = MaterialTheme.typography.h5)
                    }
                }
            }
        }
    }
}